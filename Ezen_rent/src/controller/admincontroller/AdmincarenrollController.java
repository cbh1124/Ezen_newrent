package controller.admincontroller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import controller.boardcontroller.MainpageController;
import dao.CarDao;

import domain.Car;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class AdmincarenrollController implements Initializable{
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	//
	@FXML
    private ImageView adminimg;

    @FXML
    private Button btncancel;

    @FXML
    private Button btnimgadd;

    @FXML
    private Button btnregister;

    @FXML
    private ToggleGroup category1;

    @FXML
    private ToggleGroup category2;

    @FXML
    private ToggleGroup category3;

    @FXML
    private Label lblimgpath;

    @FXML
    private RadioButton opt_1_1;

    @FXML
    private RadioButton opt_1_2;

    @FXML
    private RadioButton opt_1_3;

    @FXML
    private RadioButton opt_1_4;

    @FXML
    private RadioButton opt_2_1;

    @FXML
    private RadioButton opt_2_2;

    @FXML
    private RadioButton opt_3_1;

    @FXML
    private RadioButton opt_3_2;

    @FXML
    private TextField txtcarlicense;

    @FXML
    private TextField txtcarname;

    @FXML
    private TextField txtprice;

    @FXML
    void cancel(ActionEvent event) {
    	MainpageController.getinstance().loadpage("admin");
    }
	
	//

    @FXML
    void register(ActionEvent event) {
    	String cname = txtcarname.getText();
    	String clicense = txtcarlicense.getText();
    	int cprice = Integer.parseInt(txtprice.getText());
    	String ccategory1 = "";
    	String ccategory2 = "";
    	String ccategory3 = "";
     	// 해당 라디오 버튼을 클릭하면 값 저장 
    		if(opt_1_1.isSelected() ) { ccategory1="대형"; }
    		if(opt_1_2.isSelected() ) { ccategory1="중형"; }
    		if(opt_1_3.isSelected() ) { ccategory1="소형"; }
    		if(opt_1_4.isSelected() ) { ccategory1="기타"; }
    		
    		if(opt_2_1.isSelected() ) { ccategory2="국산"; }
    		if(opt_2_2.isSelected() ) { ccategory2="외제"; }
    		
    		if(opt_3_1.isSelected() ) { ccategory3="suv"; }
    		if(opt_3_2.isSelected() ) { ccategory3="세단"; }
    		
    		//(c_name, c_license, c_img, c_price, c_ct1, c_ct2, c_ct3, c_return)
    		Car car = new Car(cname, clicense, cimage, cprice, ccategory1, ccategory2, ccategory3, false);
    		
    		//DB 처리 
    		boolean result = CarDao.getCarDao().register(car);
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
    		if(result) {
    			alert.setHeaderText("자동차 등록 성공"); alert.showAndWait(); 
    			//MainpageController.getinstance().loadpage("mainpage");
    			MainpageController.getinstance().loadpage("admin");
    			// MainpageController.getinstance().loadpage("productlist"); // 어드민 페이지 전환으로 바꿔야됨  
    		}
    		
    }
    private String cimage; // 파일경로 저장 
    private Stage stage; // 파일 경로 찾을 화면 
    
    
    @FXML
    void imgadd(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser(); // 파일 선택시 경로 저장 
    	fileChooser.getExtensionFilters().add(
    					new ExtensionFilter("그림파일 : Image File","*png", "*jpg", "*gif" ) );
    	
    	// 스테이지에 파일 선택 클래스 넣기 
    	
    	File file = fileChooser.showOpenDialog(stage);
    	
    	lblimgpath.setText("파일 경로 : " + file.getPath());
    	
    	cimage = file.toURI().toString();
    	System.out.println( "URL 경로 : " + file.getPath() );
    	System.out.println( "URI 경로  : " + cimage );
    	
    	Image image = new Image(cimage);
    	adminimg.setImage(image);
    }

}

