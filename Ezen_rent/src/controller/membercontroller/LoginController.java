package controller.membercontroller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class LoginController implements Initializable{
	
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
		
		}
		
	    @FXML
	    private Label btnfindid;

	    @FXML
	    private Label btnfindpassword;

	    @FXML
	    private Button btnlogin;

	    @FXML
	    private Button btnsignup;

	    @FXML
	    private Label lblconfirm;

	    @FXML
	    private AnchorPane loginpane;

	    @FXML
	    private BorderPane mainboardpane;

	    @FXML
	    private TextField txtid;

	    @FXML
	    private TextField txtpassword;

	    @FXML
	    void findid(MouseEvent event) {

	    }

	    @FXML
	    void findpassword(MouseEvent event) {

	    }

	    @FXML
	    void login(ActionEvent event) {

	    }

	    @FXML
	    void signup(MouseEvent event) {
	    	
	    }
}
