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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.control.Alert.AlertType;

public class Board3_writeController implements Initializable {
	
	int carno2;
	public void reservationboardload() {
		ObservableList<Board> boards = BoardDao.getboardDao().write3(MemberDao.getMemberDao().getmno(MainpageController.getinstance().getloginid()));
		//2. 제품목록을 테이블뷰에 넣어주기
		cartable.setItems(boards);
		//3. 테이블뷰에 열 를 하나씩 가져와서 리스트내 객체에 필드와 연결 
		TableColumn tc = cartable.getColumns().get(0);
			tc.setCellValueFactory( new PropertyValueFactory<>("r_num"));
		tc = cartable.getColumns().get(1);
			tc.setCellValueFactory( new PropertyValueFactory<>("c_name"));
			
		// 테이블뷰에서 클릭했을때 아이템 가져오기 
			// 1. 테이블뷰에 클릭 이벤트 
			//productlist.setOnMouseClicked( e -> { 정의 } );
			cartable.setOnMouseClicked( e -> { 
				// 2. 클릭 이벤트가 마우스 클릭과 같으면 
				if( e.getButton().equals( MouseButton.PRIMARY ) ) {
					// 3.테이블뷰에서 클릭한 모델의 아이템[ 객체 ]
					board2 = cartable.getSelectionModel().getSelectedItem();
					carno2 = CarDao.getCarDao().carno(board2.getC_name());   
					
				}
			} );
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		reservationboardload();
		
		
	}
	
	public static Board board2 ;
	
    @FXML
    private TableView<Board> cartable;
    
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
    private TextArea txtboard3contents;

    @FXML
    private TextField txtboard3title;

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
    	MainpageController.getinstance().loadpage("board3_list");
    }

    @FXML
    void write(ActionEvent event) {
    	// Board(제목, 컨텐츠, 아이디를 통한 멤버 식별번호, 게시물 종류, 자동차 식별번호 
    	Board board = new Board(
    				txtboard3title.getText(),
    				txtboard3contents.getText(),
    				MemberDao.getMemberDao().getmno(MainpageController.getinstance().getloginid()), // 식별 번호 출력 
    				"3", // 게시물 종류 이용후기
    				carno2 // 자동차 식별번호 
    			);
    	
    	boolean result = BoardDao.getboardDao().write2(board);
    	
    	
    	Alert alert = new Alert( AlertType.INFORMATION);
    	
    	if( result ) {
    		alert.setHeaderText(" 게시물 등록 성공 ");
    		alert.showAndWait();
    		MainpageController.getinstance().loadpage("board3_list");
    	}else {
    		alert.setHeaderText(" 게시물 등록 실패 [관리자에게 문의]");
    		alert.showAndWait();
    	}
    }
}
