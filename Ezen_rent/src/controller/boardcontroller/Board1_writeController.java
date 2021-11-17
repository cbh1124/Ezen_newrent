package controller.boardcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.BoardDao;
import dao.MemberDao;
import domain.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Board1_writeController implements Initializable{
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
    @FXML
    private Button btnboard1;

    @FXML
    private Button btnboard2;

    @FXML
    private Button btnboard3;

    @FXML
    private Button btncancel;

    @FXML
    private Button btnwrite1;

    @FXML
    private TextArea txtboard1contents;

    @FXML
    private TextField txtboard1title;

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
    	MainpageController.getinstance().loadpage("board1_list");
    }

    @FXML
    void write(ActionEvent event) {
    	Board board = new Board(txtboard1title.getText(), txtboard1contents.getText(), MemberDao.getMemberDao().getmno(MainpageController.getinstance().getloginid()), "1", 1);
    	
    	boolean result = BoardDao.getboardDao().board1write(board);
    	Alert alert = new Alert(AlertType.INFORMATION);
    	if(result) {
	    	alert.setHeaderText("게시물 등록 성공");
	    	alert.showAndWait();
	    	MainpageController.getinstance().loadpage("board1_list");
    	}
    	else {
    		alert.setHeaderText("게시물 등록 실패");
    		alert.showAndWait();
    	}
    }
}
