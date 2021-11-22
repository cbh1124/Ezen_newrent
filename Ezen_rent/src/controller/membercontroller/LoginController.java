package controller.membercontroller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController implements Initializable{
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
		
		}
		
		public static LoginController instance;
		
		public LoginController() {
		 instance = this;
		}
		public static LoginController getinstance() {
			return instance;
		}
		
		// 입력된 아이디 반환
		public String getid() {
			return txtid.getText();
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
	    private PasswordField txtpassword;
	    
	    @FXML
	    void findid(MouseEvent event) {
	    	loadpage("findid");
	    }

	    @FXML
	    void findpassword(MouseEvent event) {
	    	loadpage("findpassword");
	    }

	    @FXML
	    void login(ActionEvent event) {
	    	boolean result = MemberDao.getMemberDao().login(txtid.getText(), txtpassword.getText());
	    	if( MemberDao.adminRs == false) {
		    	if(result) {
		    		lblconfirm.setText("로그인 성공");
		    		btnlogin.getScene().getWindow().hide();
		    		
		    		Stage stage = new Stage();
		    		
		    		try {
						Parent parent = FXMLLoader.load(getClass().getResource("/fxml/mainpage.fxml"));
						Scene scene = new Scene(parent);
						stage.setScene(scene);
						stage.setResizable(false);
						stage.show();
					} catch (Exception e) {}
		    	}
		    	else { lblconfirm.setText("로그인 실패 관리자에게 문의하세요"); }
	    	}else {
	    		try {
	    			lblconfirm.setText("관리자 로그인 성공");
		    		btnlogin.getScene().getWindow().hide();
		    		
		    		Stage stage = new Stage();
					Parent parent = FXMLLoader.load(getClass().getResource("/fxml/mainpage.fxml"));
					Scene scene = new Scene(parent);
					stage.setScene(scene);
					stage.setResizable(false);
					stage.show();
				} catch (Exception e) {}
	    	}
	    }

	    @FXML
	    void signup(MouseEvent event) {
	    	loadpage("signuppage");
	    }
	    
	    public void loadpage(String page) {
	    	try {
	    		Parent parent = FXMLLoader.load(getClass().getResource("/fxml/"+page+".fxml"));
	    		mainboardpane.setCenter(parent);
	    	}catch (Exception e) {}
	    }
}
