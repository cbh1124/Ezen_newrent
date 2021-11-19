package controller.reservationcontroller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
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

	// ��ϵ� ���� �ҷ�����
	public void rentcarltableload() {

		// 1. DB���� ������� ��������
		ObservableList<Car> cars = CarDao.getCarDao().carlist3();
		System.out.println("Ȯ��" + cars);
		// 2. ��ǰ����� ���̺�信 �־��ֱ�
		rentcarlist.setItems(cars);
		// 3. ���̺�信 �� �� �ϳ��� �����ͼ� ����Ʈ�� ��ü�� �ʵ�� ����
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

		// ���̺�信�� Ŭ�������� ������ ��������
		// 1. ���̺�信 Ŭ�� �̺�Ʈ

		rentcarlist.setOnMouseClicked(e -> {
			// 2. Ŭ�� �̺�Ʈ�� ���콺 Ŭ���� ������
			if (e.getButton().equals(MouseButton.PRIMARY)) {
				// 3.���̺�信�� Ŭ���� ���� ������[ ��ü ]
				car = rentcarlist.getSelectionModel().getSelectedItem();
				// 4. ���õ� ��ü�� �̹������ ��������
				Image image = new Image(car.getC_img());
				cimg.setImage(image);
				// 5. �׿�
				lblcname.setText(car.getC_name());

			}
		});

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		rentcarltableload();

	}

	public static Car car; // ������ ����

	@FXML
	Button btnreservecarButton;
	Popup popup;
	TextArea textArea;

	/////////////////////////////////////////////////////////////////
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
	private Label lbldayp;

	@FXML
	private TextField lbldaypck;

	@FXML
	private Label lblinputdate;

	@FXML
	private TextField lblinputdateck;

	@FXML
	private Label lblmid;

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
	private TextField lbltotdateck;

	@FXML
	private Label lbltotp;

	@FXML
	private TextField lbltotpck;

	@FXML
	private DatePicker outputdateDatePicker;

	@FXML
	private Button outputdateadd;

	@FXML
	private TableView<Car> rentcarlist;
	// ���̺� ���� ��ü�� Ŭ������ : ���׸�

	@FXML
	private TableView<?> reservationlist;

	@FXML
	void daypck(ActionEvent event) {

	}

	// ��Ʈ���� ����
	@FXML
	void inputdateac(ActionEvent event) {
		LocalDate rentDate = inputdateDatePicker.getValue();
		String rentFormattedDate = rentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		lblinputdateck.setText(rentFormattedDate);
	}

	@FXML
	void inputdateaddac(ActionEvent event) {

	}

	@FXML
	void inputdateck(ActionEvent event) {

	}

	// �ݳ����� ����
	@FXML
	void outputdateac(ActionEvent event) {
		LocalDate returnDate = outputdateDatePicker.getValue();
		String returnFormattedDate = returnDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		lbloutputdateck.setText(returnFormattedDate);
	}

	@FXML
	void outputdateaddac(ActionEvent event) {

	}

	@FXML
	void outputdateck(ActionEvent event) {

	}

	@FXML
	void reservecar(ActionEvent event) {
		// �˾�ȭ�� �̺�Ʈ
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

	@FXML
	void search(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText(" ������ �˻� �Ͻðڽ��ϱ�?");
		Optional<ButtonType> optional = alert.showAndWait();

		if (optional.get() == ButtonType.OK) {
			// DB ó��

		}
	}

	@FXML
	void selectcarck(ActionEvent event) {

	}

	@FXML
	void totdateck(ActionEvent event) {

	}

	@FXML
	void totpck(ActionEvent event) {

	}

	// �ݳ��� - ��Ʈ�� �޼ҵ�
	public void lbltotdateck() {

	}

}
