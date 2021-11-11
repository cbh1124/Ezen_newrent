package controller.membercontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class FindpwController {

    @FXML
    private Label btnback;

    @FXML
    private Button btnfindpassword;

    @FXML
    private Label lblconfirm;

    @FXML
    private AnchorPane signuppane;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtid;

    @FXML
    void back(MouseEvent event) {
    	LoginController.getinstance().loadpage("loginpage");
    }

    @FXML
    void findpassword(ActionEvent event) {

    }
    
}
