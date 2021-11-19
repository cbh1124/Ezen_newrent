package controller.boardcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ReplywriteController {

    @FXML
    private Button btnboard1;

    @FXML
    private Button btnboard2;

    @FXML
    private Button btnboard3;

    @FXML
    private Button btncancel;

    @FXML
    private Button btnwrite;

    @FXML
    private TextArea txtreplycontents;

    @FXML
    void board1(ActionEvent event) {
    	MainpageController.getinstance().loadpage("board1_list");
    }

    @FXML
    void board2(ActionEvent event) {
    	MainpageController.getinstance().loadpage("board2_list");
    }

    @FXML
    void board3(ActionEvent event) {
    	MainpageController.getinstance().loadpage("board3_list");
    }

    @FXML
    void cancel(ActionEvent event) {
    	MainpageController.getinstance().loadpage("board2_view");
    }

    @FXML
    void write(ActionEvent event) {
    	
    }

}
