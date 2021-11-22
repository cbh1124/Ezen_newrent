package controller.boardcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.BoardDao;
import domain.Board;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;

public class board2_listController implements Initializable{
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		ObservableList<Board> boards = BoardDao.getboardDao().board2list();
		TableColumn tc = board2list.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_num"));
		
		tc = board2list.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_title"));

		tc = board2list.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_contents"));

		tc = board2list.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_date"));
		
		tc = board2list.getColumns().get(4);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_view"));
		
		board2list.setItems(boards);
		
		board2list.setOnMouseClicked(e -> {
			if(e.getButton().equals(MouseButton.PRIMARY)) {
				board = board2list.getSelectionModel().getSelectedItem();
				MainpageController.getinstance().loadpage("board2_view");
				
			}
		});
	}
	
	public static Board board;
	//юс╫ц
	@FXML
    private TableView<Board> board2list;

    @FXML
    private Button btnboard1;

    @FXML
    private Button btnboard2;

    @FXML
    private Button btnboard3;

    @FXML
    private Button btnwrite;

    @FXML
    private AnchorPane cp;

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
    	MainpageController.getinstance().loadpage("board2_write");
    }
}
