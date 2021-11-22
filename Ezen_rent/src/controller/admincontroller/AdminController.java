package controller.admincontroller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.boardcontroller.MainpageController;
import dao.CarDao;
import dao.MemberDao;
import dao.ReservationDao;
import domain.Car;
import domain.Reservation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminController implements Initializable{
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cartableload();
		reservationtableload();
	}
	public static AdminController instance;
	public AdminController() {
		instance = this;
	}
	public static AdminController getinstance() {
		return instance;
	}
	
	//임시
	@FXML
    private AnchorPane adminpane;
	
	@FXML
    private Button btncancel;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnenroll;

    @FXML
    private Button btnupdate;

    @FXML
    private TableView<Car> carlistboard;

    @FXML
    private TableView<Reservation> reservationboardlist;

    @FXML
    void cancel(ActionEvent event) {
    	MainpageController.getinstance().loadpage("home");
    }

    @FXML
    void delete(ActionEvent event) {
    	Alert alert = new Alert( AlertType.CONFIRMATION );
    	alert.setHeaderText(" 제품을 삭제 하시겠습니까?" );
    	Optional<ButtonType> optional = alert.showAndWait();
    	if( optional.get() == ButtonType.OK ) {
    		// DB 처리 
    		CarDao.getCarDao().delete( AdminController.car.getC_num() );
    		
    		Alert alert2 = new Alert( AlertType.INFORMATION );
    		alert2.setHeaderText(" 삭제 되었습니다 "); alert2.showAndWait();
    		MainpageController.getinstance().loadpage("admin");
    	}
    }

    @FXML
    void enroll(ActionEvent event) {
    	MainpageController.getinstance().loadpage("admincarenroll");
    	System.out.println("어드민 페이지 작동!!");
    }

    @FXML
    void update(ActionEvent event) {
    	MainpageController.getinstance().loadpage("admincarupdate");
    	System.out.println("어드민 페이지 작동2!!");
    }
    
    public static Car car;
    
	public void cartableload() {
	    	
    	//1. DB에서 제품목록 가져오기
				
    			ObservableList<Car> cars = CarDao.getCarDao().carlist();
    			
    			//2. 제품목록을 테이블뷰에 넣어주기 
    			carlistboard.setItems(cars);
    			//3. 테이블뷰에 열 를 하나씩 가져와서 리스트내 객체에 필드와 연결 
    			TableColumn tc = carlistboard.getColumns().get(0);
    				tc.setCellValueFactory( new PropertyValueFactory<>("c_num"));
    			tc = carlistboard.getColumns().get(1);
    				tc.setCellValueFactory( new PropertyValueFactory<>("c_name"));
    			tc = carlistboard.getColumns().get(2);
    				tc.setCellValueFactory( new PropertyValueFactory<>("c_license"));
    			tc = carlistboard.getColumns().get(3);
    				tc.setCellValueFactory( new PropertyValueFactory<>("c_ct1"));
    			tc = carlistboard.getColumns().get(4);
    				tc.setCellValueFactory( new PropertyValueFactory<>("c_ct2"));
    			tc = carlistboard.getColumns().get(5);
    				tc.setCellValueFactory( new PropertyValueFactory<>("c_ct3"));
    			tc = carlistboard.getColumns().get(6);
    				tc.setCellValueFactory( new PropertyValueFactory<>("c_return"));
    			tc = carlistboard.getColumns().get(7);
    				tc.setCellValueFactory( new PropertyValueFactory<>("c_price"));
	    				
    				carlistboard.setOnMouseClicked( e -> { 
    					// 2. 클릭 이벤트가 마우스 클릭과 같으면 
    					if( e.getButton().equals( MouseButton.PRIMARY ) ) {
    						// 3.테이블뷰에서 클릭한 모델의 아이템[ 객체 ]
    						car = carlistboard.getSelectionModel().getSelectedItem();
    						System.out.println(car);
    						System.out.println("객체 저장됬어요");
    					}
    				} );
	  }
    public static Reservation reservation2;
	public void reservationtableload() {
		System.out.println(ReservationDao.getreservationDao().reservelist());
		
		ObservableList<Reservation> reservations = ReservationDao.getreservationDao().reservelist();
		
		System.out.println("출력" );
		//2. 제품목록을 테이블뷰에 넣어주기 
		reservationboardlist.setItems(reservations);
		//3. 테이블뷰에 열 를 하나씩 가져와서 리스트내 객체에 필드와 연결 
		TableColumn tc = reservationboardlist.getColumns().get(0);
			tc.setCellValueFactory( new PropertyValueFactory<>("r_num"));
		tc = reservationboardlist.getColumns().get(1);
			tc.setCellValueFactory( new PropertyValueFactory<>("r_dayin"));
		tc = reservationboardlist.getColumns().get(2);
			tc.setCellValueFactory( new PropertyValueFactory<>("r_dayout"));
		tc = reservationboardlist.getColumns().get(3);
			tc.setCellValueFactory( new PropertyValueFactory<>("r_plusday"));
		tc = reservationboardlist.getColumns().get(4);
			tc.setCellValueFactory( new PropertyValueFactory<>("r_totday"));
		tc = reservationboardlist.getColumns().get(5);
			tc.setCellValueFactory( new PropertyValueFactory<>("r_totprice"));
		tc = reservationboardlist.getColumns().get(6);
			tc.setCellValueFactory( new PropertyValueFactory<>("m_num"));
		tc = reservationboardlist.getColumns().get(7);
			tc.setCellValueFactory( new PropertyValueFactory<>("c_num"));
				
			reservationboardlist.setOnMouseClicked( e -> { 
				// 2. 클릭 이벤트가 마우스 클릭과 같으면 
				if( e.getButton().equals( MouseButton.PRIMARY ) ) {
					// 3.테이블뷰에서 클릭한 모델의 아이템[ 객체 ]
					reservation2 = reservationboardlist.getSelectionModel().getSelectedItem();
					System.out.println(car);
					System.out.println("객체 저장됬어요");
				}
			} );
	}
   

}
