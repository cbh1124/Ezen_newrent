package controller.reservationcontroller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import controller.boardcontroller.MainpageController;
import dao.MemberDao;
import dao.CarDao;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
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
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class ReservationController implements Initializable {

	// 등록된 차량 불러오기
	public void rentcarltableload() {

		// 1. DB에서 차량목록 가져오기
		ObservableList<Car> cars = CarDao.getCarDao().carlist();
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

		rentcarlist.setItems(cars);

		// 테이블뷰에서 클릭했을때 아이템 가져오기
		// 1. 테이블뷰에 클릭 이벤트

		rentcarlist.setOnMouseClicked(e -> {
			// 2. 클릭 이벤트가 마우스 클릭과 같으면
			if (e.getButton().equals(MouseButton.PRIMARY)) {

				// 3.테이블뷰에서 클릭한 모델의 아이템[ 객체 ]
				car = rentcarlist.getSelectionModel().getSelectedItem();

				// 4. 선택된 객체내 이미지경로 가져오기
				Image image = new Image(car.getC_img());
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

	LocalDate rentDate; // 전역변수 설정
	LocalDate returnDate; // 전역변수 설정

	@FXML
	Button btnreservecarButton;
	Popup popup;
	TextArea textArea;

	@FXML
	private Button btnreservecar;

	@FXML
	private Button btnreturncar;

	@FXML
	private Button btnsearch;

	@FXML
	private TableColumn<?, ?> c_name;

	@FXML
	private TableColumn<?, ?> c_num;
	
    @FXML
    private TableColumn<?, ?> c_ct1;

    @FXML
    private TableColumn<?, ?> c_ct2;

    @FXML
    private TableColumn<?, ?> c_ct3;
    
    @FXML
    private TableColumn<?, ?> c_price;

	@FXML
	private ImageView cimg;

	@FXML
	private DatePicker inputdateDatePicker;

	@FXML
	private Button inputdateadd;

	@FXML
	private TextField keyworldTextFilter;

	@FXML
	private Label lblcname;
	
    @FXML
    private Label lblcnum;

	@FXML
	private Label lbldayp;

	@FXML
	private Label lbldaypck;

	@FXML
	private Label lbldaypck1;

	@FXML
	private Label lbldaypck11;

	@FXML
	private Label lblinputdate;

	@FXML
	private TextField lblinputdateck;

	@FXML
	private Label lbloutputdate;

	@FXML
	private TextField lbloutputdateck;

	@FXML
	private Label lblselectcar;

	@FXML
	private MenuButton lblselectcarck;

	@FXML
	private Label lbltotdate;

	@FXML
	private Label lbltotdateck;

	@FXML
	private Label lbltotp;

	@FXML
	private Label lbltotpck;

	@FXML
	private DatePicker outputdateDatePicker;

	@FXML
	private Button outputdateadd;

	@FXML
	private TableView<Car> rentcarlist;
	// 테이블에 넣을 객체의 클래스명 : 제네릭

	@FXML
	private TableView<?> reservationlist;

	@FXML
	void inputdateac(ActionEvent event) {

	}

	@FXML
	void inputdateaddac(ActionEvent event) {
		rentDate = inputdateDatePicker.getValue();
		String rentFormattedDate = rentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		lblinputdateck.setText(rentFormattedDate);
	}

	@FXML
	void inputdateck(ActionEvent event) {

	}

	@FXML
	void outputdateac(ActionEvent event) {
		returnDate = outputdateDatePicker.getValue();
		String returnFormattedDate = returnDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		lbloutputdateck.setText(returnFormattedDate);

		// 두일자의 대한 기간
		Period period = Period.between(rentDate, returnDate);

		// days 환산
		long days = ChronoUnit.DAYS.between(rentDate, returnDate);

		// 반납일자와 렌트일자가 null값이 아니면
		if (!lblinputdateck.getText().equals("") && !lbloutputdateck.getText().equals("")) {
			lbltotdateck.setText(days + "일");
//			System.err.println(days);

//			lbltotdateck.setText(period.getYears() + " - " + period.getMonths() + " - " + period.getDays());

		}
	}

	@FXML
	void outputdateaddac(ActionEvent event) {

	}

	@FXML
	void outputdateck(ActionEvent event) {

	}

	// 팝업
	@FXML
	void reservecar(ActionEvent event) {

//		controller.boardcontroller.MainpageController.getinstance().loadpage("reservepopup");
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/reservepopup.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.setTitle("check info");
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	@FXML
	void returncar(ActionEvent event) {

	}

	// 필터 조회버튼 이벤트
	@FXML
	void search(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText(" 차량을 검색 하시겠습니까?");
		Optional<ButtonType> optional = alert.showAndWait();

		if (optional.get() == ButtonType.OK) {
			// DB 처리

		}
	}

	@FXML
	void selectcarck(ActionEvent event) {

	}

	// 반납일 - 렌트일 메소드
	public void lbltotdateck() {
		String rentFormattedDate = null;
		String returnFormattedDate = null;

		try { // String Type을 Date Type으로 캐스팅하면서 생기는 예외로 인해 여기서 예외처리 해주지 않으면 컴파일러에서 에러가 발생해서
				// 컴파일을 할 수 없다.
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			// 두 날짜를 parse()를 통해 Date형으로 변환.
			Date FirstDate = format.parse(rentFormattedDate);
			Date SecondDate = format.parse(returnFormattedDate);

			// Date로 변환된 두 날짜를 계산한 뒤 그 리턴값으로 long type 변수를 초기화 하고 있다.

			long calDate = FirstDate.getTime() - SecondDate.getTime();

			// Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다.

			long calDateDays = calDate / (24 * 60 * 60 * 1000);

			calDateDays = Math.abs(calDateDays);

			System.out.println("두 날짜의 날짜 차이: " + calDateDays);
		} catch (Exception e) {
			// 예외 처리
		}

	}

}
