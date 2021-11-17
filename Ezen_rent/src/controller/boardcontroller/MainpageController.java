package controller.boardcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.membercontroller.LoginController;
import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainpageController implements Initializable{
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		if(MemberDao.adminRs == true) {
			loadpage("admin");
			lblloginid.setText(LoginController.getinstance().getid());
			
		}else {
			lblloginid.setText(LoginController.getinstance().getid());
			loadpage("home");
			btnadmin.setVisible(false);
		}
	}
	public static MainpageController instance;
	public MainpageController() {
		instance = this;
	}
	public static MainpageController getinstance() {
		return instance;
	}
	public String getloginid() {
		return lblloginid.getText();
	}
	//임시
    @FXML
    private Button btnadmin;

    @FXML
    private MenuItem btnboard1;

    @FXML
    private MenuItem btnboard2;

    @FXML
    private MenuItem btnboard3;

    @FXML
    private SplitMenuButton btnboardlist;

    @FXML
    private Button btncarinfo;

    @FXML
    private Button btnhome;

    @FXML
    private Button btnlogout;

    @FXML
    private Button btnmyinfo;

    @FXML
    private Button btnreserve;

    @FXML
    private AnchorPane cp;

    @FXML
    private Label lblloginid;

    @FXML
    private BorderPane mainpageborderpane;

    @FXML
    private AnchorPane tp;

    @FXML
    void admin(ActionEvent event) {
    	loadpage("admin");
    }

    @FXML // 고객센터 공지사항 
    void board1(ActionEvent event) {
    	loadpage("board1_list");
    	System.out.println("board1_list");
    }

    @FXML // 고객센터 Q&A
    void board2(ActionEvent event) {
    	loadpage("board2_list");
    	System.out.println("board2_list");
    }

    @FXML // 이용후기 
    void board3(ActionEvent event) {
    	loadpage("board3_list");
    	System.out.println("board3_list");
    }

    @FXML
    void boardlist(ActionEvent event) {
    	loadpage("board1_list");
    	System.out.println("board1_list");
    }

    @FXML
    void carinfo(ActionEvent event) {
    	loadpage("carinfo");
    }

    @FXML
    void home(ActionEvent event) {
    	loadpage("home");
    }
    // 로그아웃
    @FXML
    void logout(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setContentText("로그아웃");
    	alert.setHeaderText("로그아웃 하시겠습니까?");
    	alert.setTitle("확인");
    	
    	Optional<ButtonType> optional = alert.showAndWait();
    	if(optional.get() == ButtonType.OK) {
    		
    		btnlogout.getScene().getWindow().hide();
    		
    		Stage stage = new Stage();
    		
    		try {
				Parent parent =  FXMLLoader.load(getClass().getResource("/fxml/loginpage.fxml"));
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.setResizable(false);
				stage.show();
			} catch (IOException e) {}
    		
    	}
    }

    @FXML
    void myinfo(ActionEvent event) {
    	loadpage("myinfo");
    }

    @FXML
    void reserve(ActionEvent event) {
    	loadpage("reserve");
    }
    
    // 페이지 변환
    public void loadpage(String page) {
    	try {
			Parent parent = FXMLLoader.load(getClass().getResource("/fxml/"+page+".fxml"));
			mainpageborderpane.setCenter(parent);
		} catch (Exception e) {}
    }
}