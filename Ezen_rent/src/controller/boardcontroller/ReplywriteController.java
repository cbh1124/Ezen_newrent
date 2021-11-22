package controller.boardcontroller;

import dao.BoardDao;
import dao.MemberDao;
import domain.Board;
import domain.Reply;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;

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
   	Reply reply = new Reply(txtreplycontents.getText(),board2_listController.board.getB_num(),MemberDao.getMemberDao().getmno(MainpageController.getinstance().getloginid()) );
	System.out.println("오류");
   	boolean result = BoardDao.getboardDao().replywrite(reply);
   	if(result) {
   	
   		Alert alert = new Alert(AlertType.INFORMATION);
   		alert.setHeaderText("댓글 등록");
   		alert.showAndWait();
   		MainpageController.getinstance().loadpage("board2_list");
   	}
    }

}
