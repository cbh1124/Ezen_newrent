package controller.boardcontroller;

import dao.BoardDao;
import dao.MemberDao;
import domain.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Board2_writeController {


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
    private TextArea txtboard2contents;

    @FXML
    private TextField txtboard2title;

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
    	MainpageController.getinstance().loadpage("board2_list");
    }

    @FXML
    void write(ActionEvent event) {
    	Board board = new Board(txtboard2title.getText(),txtboard2contents.getText(),MemberDao.getMemberDao().getmno(MainpageController.getinstance().getloginid()),"2",1);
    	boolean result = BoardDao.getboardDao().board2write(board);
    	Alert alert = new Alert(AlertType.INFORMATION);
    	if(result) {
    		alert.setHeaderText("게시물 등록 성공");
	    	alert.showAndWait();
	    	MainpageController.getinstance().loadpage("board2_list");
    	}else {
    		alert.setHeaderText("게시물 등록 실패");
    		alert.showAndWait();
    	}		
    }

}
