package controller.boardcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.BoardDao;
import dao.CarDao;
import dao.MemberDao;
import domain.Board;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;

public class board3_listController implements Initializable{
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
//	
//	public void reservationboardload() {
//		ObservableList<Board> boards = BoardDao.getboardDao().write3();
//		//2. 제품목록을 테이블뷰에 넣어주기
//		cartable.setItems(boards);
//		//3. 테이블뷰에 열 를 하나씩 가져와서 리스트내 객체에 필드와 연결 
//		TableColumn tc = cartable.getColumns().get(0);
//			tc.setCellValueFactory( new PropertyValueFactory<>("r_num"));
//		tc = cartable.getColumns().get(1);
//			tc.setCellValueFactory( new PropertyValueFactory<>("c_name"));
//			
//		// 테이블뷰에서 클릭했을때 아이템 가져오기 
//			// 1. 테이블뷰에 클릭 이벤트 
//			//productlist.setOnMouseClicked( e -> { 정의 } );
//			cartable.setOnMouseClicked( e -> { 
//				// 2. 클릭 이벤트가 마우스 클릭과 같으면 
//				if( e.getButton().equals( MouseButton.PRIMARY ) ) {
//					// 3.테이블뷰에서 클릭한 모델의 아이템[ 객체 ]
//					board2 = cartable.getSelectionModel().getSelectedItem();
//					carno2 = CarDao.getCarDao().carno(board2.getC_name());   
//					
//				}
//			} );
//	}
	
	//임시
	@FXML
    private TableView<?> board3list;

    @FXML
    private Button btnactivation;

    @FXML
    private Button btnboard1;

    @FXML
    private Button btnboard2;

    @FXML
    private Button btnboard3;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnregister;

    @FXML
    private Button btnupdate;

    @FXML
    private Label lblrname;

    @FXML
    private ImageView rimg;

    @FXML
    void activation(ActionEvent event) {

    }

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
    void delete(ActionEvent event) {
    	
    }

    @FXML
    void register(ActionEvent event) {
    	MainpageController.getinstance().loadpage("board3_write");
    }

    @FXML
    void update(ActionEvent event) {
    	
    }
}
