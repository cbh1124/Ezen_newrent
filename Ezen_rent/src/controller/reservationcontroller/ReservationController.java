package controller.reservationcontroller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.MemberDao;
import dao.CarDao;
import dao.ReservationDao;
import domain.Car;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class ReservationController implements Initializable {

	// 등록된 차량 불러오기
	public void rentcarltableload() {
		0.

		// 1. DB에서 차량목록 가져오기
		ObservableList<Car> cars = CarDao.getCarDao().carlist3();
		System.out.println("확인" + cars);
		// 2. 제품목록을 테이블뷰에 넣어주기
		rentcarlist.setItems(cars);
		// 3. 테이블뷰에 열 를 하나씩 가져와서 리스트내 객체에 필드와 연결
		TableColumn tc = rentcarlist.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("c_num"));
		tc = rentcarlist.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("c_name"));
		tc = rentcarlist.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("c_ct1"));
		tc = rentcarlist.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("c_ct2"));
		tc = rentcarlist.getColumns().get(4);
		tc.setCellValueFactory(new PropertyValueFactory<>("c_ct3"));
		tc = rentcarlist.getColumns().get(5);
		tc.setCellValueFactory(new PropertyValueFactory<>("c_price"));

		// 테이블뷰에서 클릭했을때 아이템 가져오기
		// 1. 테이블뷰에 클릭 이벤트
		// productlist.setOnMouseClicked( e -> { 정의 } );
		rentcarlist.setOnMouseClicked(e -> {
			// 2. 클릭 이벤트가 마우스 클릭과 같으면
			if (e.getButton().equals(MouseButton.PRIMARY)) {
				// 3.테이블뷰에서 클릭한 모델의 아이템[ 객체 ]
				car = rentcarlist.getSelectionModel().getSelectedItem();
				// 4. 선택된 객체내 이미지경로 가져오기
				Image image = new Image( car.getC_img() );
				cimg.setImage(image);
				// 5. 그외
				lblcname.setText(car.getC_name());

			}
		});

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		rentcarltableload();

	}

	public static Car car; // 밖으로 빼줌

	@FXML
	private Button btnreservecar;

	@FXML
	private Button btnreturncar;

	@FXML
	private Button btnsearch;

	@FXML
	private ImageView cimg;

	@FXML
	private DatePicker inputdate;

	@FXML
	private Label lblcname;

	@FXML
	private Label lbldayp;

	@FXML
	private Label lblinputdate;

	@FXML
	private Label lblmid;

	@FXML
	private Label lbloutputdate;

	@FXML
	private Label lbltotdate;

	@FXML
	private Label lbltotp;

	@FXML
	private DatePicker outputdate;

	@FXML
	private TableView<Car> rentcarlist;

	@FXML
	private TableView<?> reservationlist;

	@FXML
	private TextField searchtxt;

	@FXML
	void reservecar(ActionEvent event) {

	}

	@FXML
	void returncar(ActionEvent event) {

	}

	@FXML
	void search(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText(" 차량을 검색 하시겠습니까?");
		Optional<ButtonType> optional = alert.showAndWait();

		if (optional.get() == ButtonType.OK) {
			// DB 처리

		}

	}
	
	

}
