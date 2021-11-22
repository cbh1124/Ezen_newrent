package controller.boardcontroller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.BoardDao;
import domain.Board;
import domain.Reply;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;

public class Board2_viewController implements Initializable{
	
	Board board = board2_listController.board;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	txttitle.setText(board.getB_title());
	txtcontents.setText(board.getB_contents());
	lblwriter.setText(BoardDao.getboardDao().getmid(board.getM_num() ) );
	lbldate.setText(board.getB_date().split(" ")[0] );
	lblview.setText(""+(board.getB_view() + 1));
	
	if(!MainpageController.getinstance().getloginid().equals(BoardDao.getboardDao().getmid(board.getM_num()))  ) {
		btnupdate.setVisible(false);
		btndelete.setVisible(false);
	}
	
	if(!MainpageController.getinstance().getloginid().equals("admin")) {
		btnreplywrite.setVisible(false);
	}
	BoardDao.getboardDao().viewupdate(board.getB_num());
	replytalble();
	}
	
    @FXML
    private TableView<Reply> answerlist;
    
    public void replytalble() {
    	
    	ObservableList<Reply> replys = BoardDao.getboardDao().replylist(board.getB_num());
    	
    	TableColumn tc = answerlist.getColumns().get(0);
    	tc.setCellValueFactory(new PropertyValueFactory<>("br_num"));
    	
    	tc = answerlist.getColumns().get(1);
    	tc.setCellValueFactory(new PropertyValueFactory<>("br_contents"));
    	
    	tc = answerlist.getColumns().get(2);
    	tc.setCellValueFactory(new PropertyValueFactory<>("br_date"));
    	
    	answerlist.setItems(replys);
    	
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
    private Button btndelete;

    @FXML
    private Button btnreplywrite;

    @FXML
    private Button btnupdate;

    @FXML
    private Label lbldate;

    @FXML
    private Label lblview;

    @FXML
    private Label lblwriter;

    @FXML
    private TextArea txtcontents;

    @FXML
    private TextField txttitle;

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
    void delete(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("게시물을 삭제하시겠습니까?");
    	alert.setTitle("알림");
    	Optional<ButtonType> optional = alert.showAndWait();
    	if(optional.get() == ButtonType.OK) {
    	boolean result = BoardDao.getboardDao().boarddelete(board.getB_num());
       	if(result) { 
    		System.out.println("?????");
    		MainpageController.getinstance().loadpage("board2_list"); }
    	}
    }

    	boolean upcheck = true;
    @FXML
    void update(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	if(upcheck) {
    	alert.setHeaderText("내용 수정후 버튼 클릭시 수정 완료 됩니다.");
    	alert.showAndWait();
    	txttitle.setEditable(true);
    	txtcontents.setEditable(true);
    	upcheck = false;
    	}
    	else { 
    		BoardDao.getboardDao().board2update(board.getB_num(), txttitle.getText(), txtcontents.getText());
    		alert.setHeaderText("수정이 완료되었습니다.");
    		alert.showAndWait();
    		upcheck = false;
    		txttitle.setEditable(false);
    		txtcontents.setEditable(false);
    	}
    }

    @FXML
    void replywrite(ActionEvent event) {
    	MainpageController.getinstance().loadpage("replywrite");
    }
}
