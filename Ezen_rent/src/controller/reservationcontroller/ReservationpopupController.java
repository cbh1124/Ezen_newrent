package controller.reservationcontroller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.boardcontroller.MainpageController;
import dao.MemberDao;
import dao.CarDao;
import dao.ReservationDao;
import domain.Car;
import domain.Member;
import domain.Reservation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Window;

public class ReservationpopupController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblselectcar.setText( ReservationController.reservation2.getC_num() + "");
		lblinputdate.setText(ReservationController.reservation2.getR_dayin() + "" );
		lbloutputdate.setText(ReservationController.reservation2.getR_dayout() + "" );
		lbltotdate.setText(ReservationController.reservation2.getR_totday() + "");
		lbltotp.setText(ReservationController.reservation2.getR_totprice() + "");
	}

	@FXML
	private Button btnreservecarck;

	@FXML
	private Label lblinputdate;

	@FXML
	private Label lbloutputdate;

	@FXML
	private Label lblselectcar;

	@FXML
	private Label lbltotdate;

	@FXML
	private Label lbltotp;

	@FXML
	private AnchorPane registercheck;

	@FXML
    void reservecarck(ActionEvent event) {
		ReservationDao.getreservationDao().write(ReservationController.reservation2);
		System.out.println(ReservationController.reservation2.getM_num()+ "출력된건가?");
		System.out.println(ReservationController.reservation2.getC_num()+ "출력된건가?");
		System.out.println(ReservationController.reservation2.getR_totprice().getClass().getName() + "출력된건가?");
		System.out.println(ReservationController.reservation2.getR_totday().getClass().getName() + "출력된건가?");
		System.out.println(ReservationController.reservation2.getR_dayin().getClass().getName() + "출력된건가?");
		System.out.println(ReservationController.reservation2.getR_dayout().getClass().getName() + "출력된건가?");
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText(" 렌트예약을 하시겠습니까?");
		Optional<ButtonType> optional = alert.showAndWait();
		
		if (optional.get() == ButtonType.OK) {
			
	   		// 로그인된 id의 회원번호 검색 db처리
//    		int m_num = MemberDao.getMemberDao().
//    				mnumcheck( controller.boardcontroller.MainpageController.getinstance().getloginid() );
			
////			// 객체화 [ 상태 초기값 = 1 ]
//	    	Reservation reservation = new Reservation(int r_num , int m_num , int c_num , String r_dayin , r_dayout , r_plusday , r_totday , r_totprice ); 

			
			
//			// DB처리  - 
//	    	boolean result = ReservationDao.getreservationDao().reservecarck( reservation);
	    	
	    	Alert alert2 = new Alert( AlertType.INFORMATION );
	    	
	    	alert2.setHeaderText("예약 등록 성공"); alert2.showAndWait();	// 메시지창 띄우기 
    		MainpageController.getinstance().loadpage("reserve"); // 페이지 전환]
    		
    		
    			ReservationController.stage2.close();
    		
    		
    		
//	    	if( result ) {
//	    		alert.setHeaderText("예약 등록 성공"); alert.showAndWait();	// 메시지창 띄우기 
//	    		controller.boardcontroller.MainpageController.getinstance().loadpage("reserve"); // 페이지 전환 
//	    	}
		
			

		}
		
    	

    	
    }

}
