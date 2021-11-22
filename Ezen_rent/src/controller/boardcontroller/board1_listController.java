package controller.boardcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.BoardDao;
import dao.MemberDao;
import domain.Board;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;

public class board1_listController implements Initializable{
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		txttitle.setText("");
		
		if(MemberDao.adminRs == true) {	btnwrite.setVisible(true); }
		else { btnwrite.setVisible(false); }
		
		ObservableList<Board> boards = BoardDao.getboardDao().board1list();
		
		TableColumn tc = board1list.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_num"));
		
		tc = board1list.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_title"));

		tc = board1list.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_contents"));
		
		tc = board1list.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_date"));
		
		board1list.setItems(boards);
		
		board1list.setOnMouseClicked(e -> {
			
			if(e.getButton().equals(MouseButton.PRIMARY)) {
				board = board1list.getSelectionModel().getSelectedItem(); 
				txttitle.setText(board.getB_title());
				txtdate.setText(board.getB_date());
				txtcontents.setText(board.getB_contents());
			}
		});
	}
	
	public static Board board;
	//юс╫ц
	@FXML
    private TableView<Board> board1list;

	@FXML
	private Button btnboard1;

	@FXML
	private Button btnboard2;

	@FXML
	private Button btnboard3;

	@FXML
	private Button btnwrite;
	
	@FXML
	private TextArea txtcontents;

	@FXML
	private Text txtdate;

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
    void write(ActionEvent event) {
    	MainpageController.getinstance().loadpage("board1_write");
    }
}
