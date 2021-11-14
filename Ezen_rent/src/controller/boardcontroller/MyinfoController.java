package controller.boardcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MyinfoController implements Initializable {
	//임시
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	//임시

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

    }

    @FXML
    void update(ActionEvent event) {

    }

}
