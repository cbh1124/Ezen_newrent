package controller.boardcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.membercontroller.LoginController;
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
	lblloginid.setText(LoginController.getinstance().getid());
		loadpage("home");
		
	}

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

    }

    @FXML
    void board1(ActionEvent event) {

    }

    @FXML
    void board2(ActionEvent event) {

    }

    @FXML
    void board3(ActionEvent event) {

    }

    @FXML
    void boardlist(ActionEvent event) {

    }

    @FXML
    void carinfo(ActionEvent event) {
    	loadpage("carinfo");
    }

    @FXML
    void home(ActionEvent event) {
    	loadpage("home");
    }

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
    
    public void loadpage(String page) {
    	try {
			Parent parent = FXMLLoader.load(getClass().getResource("/fxml/"+page+".fxml"));
			mainpageborderpane.setCenter(parent);
		} catch (Exception e) {}
    }
}
