package controller.membercontroller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class FindidController implements Initializable{
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	lblconfirm.setText("");
		
	}

    @FXML
    private Label btnback;

    @FXML
    private Button btnfindid;

    @FXML
    private Label lblconfirm;

    @FXML
    private AnchorPane signuppane;

    @FXML
    private AnchorPane findidpane;
    
    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtname;

    @FXML
    void back(MouseEvent event) {
    	LoginController.getinstance().loadpage("loginpage");
    }

    @FXML
    void findid(ActionEvent event) {
    	String result = MemberDao.getMemberDao().findid(txtname.getText(), txtemail.getText());
    	
    	if(result != null ) { lblconfirm.setText("회원님의 아이디는 : "+result+ " 입니다." ); }
    	else { lblconfirm.setText("일치하는 정보가 존재하지 않습니다."); }
    }

}
