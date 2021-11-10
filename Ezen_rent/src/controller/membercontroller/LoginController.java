package controller.membercontroller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class LoginController implements Initializable{
	
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
		lblloginfirm.setText("");
		
		}
		
	    @FXML
	    private Label lblloginfirm;
		
	    @FXML
	    private Button btnfindid;

	    @FXML
	    private Button btnfindpw;

	    @FXML
	    private Button btnlogin;

	    @FXML
	    private Button btnsignup;

	    @FXML
	    private AnchorPane loginpane;

	    @FXML
	    private BorderPane mbp;

	    @FXML
	    private TextField txtid;

	    @FXML
	    private TextField txtpw;

	    @FXML
	    void findid(ActionEvent event) {

	    }

	    @FXML
	    void findpw(ActionEvent event) {

	    }

	    @FXML
	    void login(ActionEvent event) {
	    	
	    }

	    @FXML
	    void signup(ActionEvent event) {

	    }

}
