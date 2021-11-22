package controller.boardcontroller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.BoardDao;
import dao.MemberDao;
import domain.Board;
import domain.Member;
import domain.Reply;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MyinfoController implements Initializable {
	//임시
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Member member = MemberDao.getMemberDao().getMember(loginid);
		myinfoQnAlist();
		lblloginid.setText(member.getM_id());
		lblid.setText(member.getM_id());
		lblname.setText(member.getM_name());
		lblemail.setText(member.getM_email());
	}
	//임시
	String loginid = MainpageController.getinstance().getloginid();
		
	public void myinfoQnAlist() {
		
		ObservableList<Board> board2 = BoardDao.getboardDao().myinfoboard2list(MemberDao.getMemberDao().getmno(loginid));
		
		board2list.setItems(board2);
		
    	TableColumn tc = board2list.getColumns().get(0);
    	tc.setCellValueFactory(new PropertyValueFactory<>("b_num"));
    	
    	tc = board2list.getColumns().get(1);
    	tc.setCellValueFactory(new PropertyValueFactory<>("b_title"));
    	
    	tc = board2list.getColumns().get(2);
    	tc.setCellValueFactory(new PropertyValueFactory<>("b_date"));
    	
     	tc = board2list.getColumns().get(3);
    	tc.setCellValueFactory(new PropertyValueFactory<>("b_view"));
    	
    	board2list.setItems(board2);
    	
    }
	

    @FXML
    private TableView<Board> board2list;

    @FXML
    private TableView<Board> board3list;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnupdate;

    @FXML
    private Label lblemail;

    @FXML
    private Label lblid;

    @FXML
    private Label lblloginid;

    @FXML
    private Label lblname;

    @FXML
    private TableView<?> myreservation;

    @FXML
    void delete(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("알림");
    	alert.setHeaderText("정말 탈퇴하시겠습니까?");
    	
    	Optional<ButtonType> optional = alert.showAndWait();
    	if(optional.get() == ButtonType.OK) {
    		boolean result = MemberDao.getMemberDao().delete(lblloginid.getText());
    		Alert alert2 = new Alert( AlertType.INFORMATION);
    		
    		if(result) {
    			alert2.setHeaderText("회원탈퇴가 완료되었습니다.");
    			alert2.setTitle("알림");
    			alert2.showAndWait();
    			 btndelete.getScene().getWindow().hide();
    			 
    			 Stage stage = new Stage();
    			 try {
    				 Parent parent = FXMLLoader.load(getClass().getResource("/fxml/loginpage.fxml"));
    				 Scene scene = new Scene(parent);
    				 stage.setScene(scene);
    				 stage.setResizable(false);
    				 stage.setTitle("EzenRentCar");
    				 stage.show();
    			 }catch (Exception e) {System.out.println("화면교체 오류");}
    		} else { 
    			alert2.setHeaderText("[ 회원탈퇴 실패 ]관리자에게 문의");
    			alert2.setTitle("알림");
    			alert2.showAndWait();
    		}
    	}
    }

    @FXML
    void update(ActionEvent event) {
    	MainpageController.getinstance().loadpage("myinfoupdate");
    }

}
