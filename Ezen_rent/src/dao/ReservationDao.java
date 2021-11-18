package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import domain.Reservation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReservationDao {

	// 1. �ʵ�
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	// ��ü
	public static ReservationDao reservation = new ReservationDao();

	// 2. ������
	public ReservationDao() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://goldcon2.hopto.org:3309/ezen?serverTimezone=UTC",
					"root", "1234");
			System.out.println(" db ���� ����");
		} catch (Exception e) {
			System.out.println(" * DB ���� ���� : " + e);
		}

	}

	// ��ü ��ȯ �޼ҵ�
	public static ReservationDao getreservationDao() {
		return reservation;
	}

	// 3. �޼ҵ�

	// 1. ������ �޼ҵ�

	public boolean write(Reservation reservation) {
		String sql = "insert into Reservation( r_num , m_num , c_num , r_dayin , r_dayout , r_plusday , r_totday , r_totprice ) values( ? , ? , ? , ? , ? , ? , ? , ? )";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, reservation.getR_num());
			preparedStatement.setInt(2, reservation.getM_num());
			preparedStatement.setInt(3, reservation.getC_num());
			preparedStatement.setString(4, reservation.getR_dayin());
			preparedStatement.setString(5, reservation.getR_dayout());
			preparedStatement.setString(6, reservation.getR_plusday());
			preparedStatement.setString(7, reservation.getR_totday());
			preparedStatement.setString(8, reservation.getR_totprice());
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	// ������� �޼ҵ�
	public boolean update(int r_num, int c_num, String r_dayin, String r_dayout, String r_plusday, String r_totday,
			String r_totprice) {

		// reservation ���̺� ��ȣ�� ���� �������� ã�Ƽ� ������Ʈ�� �ϴ� ����
		String sql = "update Reservation set c_num=? , r_dayin=? , r_dayout=? , r_plusday=? , r_totday=? , r=totprice=? where r_num = ?"; // ������Ʈ
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, r_num);
			preparedStatement.setInt(3, c_num);
			preparedStatement.setString(4, r_dayin);
			preparedStatement.setString(5, r_dayout);
			preparedStatement.setString(6, r_plusday);
			preparedStatement.setString(7, r_totday);
			preparedStatement.setString(8, r_totprice);
			preparedStatement.executeUpdate(); // sql ����
			return true;
		} catch (Exception e) {

		}
		return false;
	}

	// ������ȸ����Ʈ �޼ҵ�
	public ObservableList<Reservation> reservelist() {

		ObservableList<Reservation> reservations = FXCollections.observableArrayList();

		// 0 . ����Ʈ ����
		ArrayList<Reservation> arrayList = new ArrayList<Reservation>();

		// 1. ���� ���� ��� ��������

		String sql = "select * from Reservation order by r_num desc"; // ���� ������ �ش� ���� desc �� ������������ �������°�
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			// 2.
			while (resultSet.next()) {
				// ���� ����� ���ڵ尡 ������ ���� �ݺ�
				Reservation reservation = new Reservation ( resultSet.getInt(1), 
						resultSet.getInt(2),
						resultSet.getInt(3),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getString(7),
						resultSet.getString(8) );
						
				// ��ü�� ����Ʈ�� ���
				reservations.add(reservation);
			}
			return reservations;
		} catch (Exception e) {
		}
		return reservations; // ��ü���� reservation ���� ������ reservations�� ��ȯ
	}

	// ��Ʈ ����
	

	// ���ฮ��Ʈ ��ȸ?

} // C E
