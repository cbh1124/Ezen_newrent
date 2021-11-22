package controller.homecontroller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.BoardDao;
import dao.CarDao;
import dao.MemberDao;
import dao.ReservationDao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class homecontroller implements Initializable {

	@Override // 11.08-1
	public void initialize(URL arg0, ResourceBundle arg1) {

		// ÀüÃ¼ ¼ö
		lbltotalmember.setText( MemberDao.getMemberDao().m_numcount()+"" );
		lbltotalcar.setText( CarDao.getCarDao().c_numcount()+"" );
		lbltotalrent.setText( ReservationDao.getreservationDao().r_numcount()+"" );
		lbltotalboard.setText( BoardDao.getboardDao().b_numcount()+"" );
		
	}

	@FXML
	private BarChart bc1;

	@FXML
	private BarChart bc2;

	@FXML
	private BarChart bc3;

	@FXML
	private AnchorPane cp;

	@FXML
	private Label lblcategory1;

	@FXML
	private Label lblcategory2;

	@FXML
	private Label lblcategory3;

	@FXML
	private Label lbldecrease;

	@FXML
	private Label lblincrease;

	@FXML
	private Label lbltotalboard;

	@FXML
	private Label lbltotalcar;

	@FXML
	private Label lbltotalmember;

	@FXML
	private Label lbltotalrent;

	@FXML
	private LineChart lc;

	@FXML
	private PieChart pc;
}
