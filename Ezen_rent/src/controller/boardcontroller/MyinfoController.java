package controller.boardcontroller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.MemberDao;
import domain.Member;
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
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MyinfoController implements Initializable {
	//�ӽ�
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String loginid = MainpageController.getinstance().getloginid();
		Member member = MemberDao.getMemberDao().getMember(loginid);
		
		lblid.setText(member.getM_id());
		lblloginid.setText(member.getM_id());
		lblemail.setText(member.getM_email());
		lblname.setText(member.getM_name());
	}
	//�ӽ�

    @FXML
    private TableView<?> board2list;

    @FXML
    private TableView<?> board3list;

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
    	alert.setTitle("�˸�");
    	alert.setHeaderText("ȸ��Ż�� �Ͻðڽ��ϱ�?");
    	
    	Optional<ButtonType> optional = alert.showAndWait();
    	if(optional.get()==ButtonType.OK) {
    		boolean result = MemberDao.getMemberDao().delete(lblid.getText());
    		
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		
    		if(result) {
    			alert2.setHeaderText("ȸ��Ż�� �Ϸ�Ǿ����ϴ�");
    			alert2.setTitle("�˸�");
    			alert2.showAndWait();
    			
    			btndelete.getScene().getWindow().hide();
    			
    			Stage stage = new Stage();
    			try {
					Parent parent = FXMLLoader.load(getClass().getResource("/fxml/.loginpage.fxml"));
					Scene scene = new Scene(parent);
					stage.setScene(scene);
					stage.setResizable(false);
					stage.setTitle("EzenRentCar");
					stage.show();
				} catch (Exception e) {}
    		}
    	}
    }

    @FXML
    void update(ActionEvent event) {
    	MainpageController.getinstance().loadpage("myinfoupdate");
    }

}
