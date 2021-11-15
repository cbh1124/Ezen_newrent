package controller.boardcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import domain.Member;
//import dao.MemberDao;
//import domain.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MyinfoupdateController implements Initializable{
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	String loginid = MainpageController.getinstance().getloginid();
	Member member = MemberDao.getMemberDao().ge
		
	}

    @FXML
    private Button btncancel;

    @FXML
    private Button btnupdate;

    @FXML
    private TextField lblemail;

    @FXML
    private Label lblloginid;

    @FXML
    private Label lblloginid2;

    @FXML
    private Label lblloginname;

    @FXML
    private PasswordField lblpassword;

    @FXML
    private PasswordField lblpasswordconfirm;

    @FXML
    private TextField lblphone;
    
    @FXML
    void back(ActionEvent event) {
    	MainpageController.getinstance().loadpage("myinfo");
    	
    }
 
    @FXML
    void update(ActionEvent event) {
    	
    }

}
