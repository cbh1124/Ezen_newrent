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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class ReservationpopupController implements Initializable {

	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	@FXML
    private Button btnreservecar;

    @FXML
    private TextField lblinputdate;

    @FXML
    private TextField lbloutputdate;

    @FXML
    private TextField lblselectcar;

    @FXML
    private Label lbltotdate;

    @FXML
    private AnchorPane registercheck;

    @FXML
    void reservecar(ActionEvent event) {
    	controller.boardcontroller.MainpageController.getinstance().loadpage("reserve");
    }

	

	
	
	

}
