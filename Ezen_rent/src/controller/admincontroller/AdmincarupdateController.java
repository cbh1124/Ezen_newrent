package controller.admincontroller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
 // 왜 안되지
public class AdmincarupdateController implements Initializable{
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
	}
	
	
	@FXML
    private ImageView adminimg;

    @FXML
    private Button btncancel;

    @FXML
    private Button btnimgadd;

    @FXML
    private Button btnupdate;

    @FXML
    private ToggleGroup category1;

    @FXML
    private ToggleGroup category2;

    @FXML
    private ToggleGroup category3;

    @FXML
    private Label lblimgpath;

    @FXML
    private RadioButton opt_1_1;

    @FXML
    private RadioButton opt_1_2;

    @FXML
    private RadioButton opt_1_3;

    @FXML
    private RadioButton opt_1_4;

    @FXML
    private RadioButton opt_2_1;

    @FXML
    private RadioButton opt_2_2;

    @FXML
    private RadioButton opt_3_1;

    @FXML
    private RadioButton opt_3_2;

    @FXML
    private TextField txtcarlicense;

    @FXML
    private TextField txtcarname;

    @FXML
    private TextField txtprice;

    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void imgadd(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {

    }

}
