package controller.admincontroller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AdminController implements Initializable{
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
	}
	//юс╫ц
	@FXML
    private Button btncancel;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnenroll;

    @FXML
    private Button btnupdate;

    @FXML
    private TableView<?> carlistboard;

    @FXML
    private TableView<?> reservationboardlist;

    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void enroll(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {

    }

    

}
