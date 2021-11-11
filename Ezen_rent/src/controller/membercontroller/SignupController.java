package controller.membercontroller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import domain.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class SignupController implements Initializable{
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	lblconfirm.setText("");
		
	}

	   @FXML
	    private Label btnback;

	    @FXML
	    private Button btnsignup;

	    @FXML
	    private Label lblconfirm;

	    @FXML
	    private AnchorPane signuppane;

	    @FXML
	    private TextField txtemail;

	    @FXML
	    private TextField txtid;

	    @FXML
	    private TextField txtname;

	    @FXML
	    private PasswordField txtpassword;

	    @FXML
	    private PasswordField txtpasswordconfirm;
	   
	    @FXML
	    private TextField txtphone;
	    
	    @FXML
	    private TextField txtdob;

	    @FXML
	    void back(MouseEvent event) {
	    	LoginController.getinstance().loadpage("loginpage");
	    }

	    @FXML
	    void signup(ActionEvent event) {
	    	if( txtid.getText().length() < 5 || txtid.getText().length() > 13) {
	    		lblconfirm.setText("아이디는 5~ 12 글자 사이로 가능합니다."); return;
	    	}
	    	if( txtpassword.getText().length() < 8 || txtpassword.getText().length() > 21) {
	    		lblconfirm.setText("비밀번호는 8 ~ 20 글자 사이로 가능합니다."); return;
	    	}
	    	if( !txtpassword.getText().equals(txtpasswordconfirm.getText())) {
	    		lblconfirm.setText("비밀번호가 동일하지 않습니다."); return;
	    	}
	    	if( txtname.getText().length() < 2 ) {
	    		lblconfirm.setText("이름은 2글자 이상 가능합니다."); return;
	    	}
	    	if( txtemail.getText().length() < 5 && !txtemail.getText().contains("@")) {
	    		lblconfirm.setText("이메일은 5글자 이상 @를 포함하여야 합니다."); return;
	    	}
	    	if( txtdob.getText().length() < 6 || txtdob.getText().length() > 7) { 
	    		lblconfirm.setText("생년월일은 6자리로 작성해주시기 바랍니다. (주민번호 앞자리)"); return;
	    	}
	    	if( txtphone.getText().length() < 10 || txtphone.getText().length()>12) {
	    		lblconfirm.setText("연락처는 -을 제외한 10 ~ 11자리로 입력하시기 바랍니다. "); return;
	    	}
	    	boolean idcheck = MemberDao.getMemberDao().idcheck(txtid.getText());
	    	if(idcheck) { lblconfirm.setText("현재 사용중인 아이디입니다."); return;}
	    	
	    	Member member = new Member(txtid.getText(), txtpassword.getText(), txtname.getText(), txtemail.getText(), txtdob.getText(), txtphone.getText());
	    	
	    	boolean result = MemberDao.getMemberDao().signup(member);
	    	if(result) {
	    		lblconfirm.setText("회원가입 완료");
	    		
	    		Alert alert = new Alert(AlertType.INFORMATION);
	    		alert.setContentText("회원가입 성공");
	    		alert.setHeaderText("가입해 주셔서 감사합니다.");
	    		alert.setTitle("알림");
	    		alert.showAndWait();
	    		LoginController.getinstance().loadpage("loginpage");
	    	}
	    	else { lblconfirm.setText("회원가입 실패 [관리자 문의]"); }
	    }

}
