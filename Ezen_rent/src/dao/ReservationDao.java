package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import domain.Car;
import domain.Reservation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReservationDao {

	// 1. 필드
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	// 객체
	public static ReservationDao reservationDao = new ReservationDao();

	// 2. 생성자
	public ReservationDao() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://goldcon2.hopto.org:3309/ezen?serverTimezone=UTC",
					"root", "1234");
			System.out.println(" db 연동 성공");
		} catch (Exception e) {
			System.out.println(" * DB 연동 실패 : " + e);
		}

	}
	
	// 객체 반환 메소드
	public static ReservationDao getreservationDao() {
		return reservationDao;
	}

	// 3. 메소드

	// 1. 예약등록 메소드

	public boolean write(Reservation reservation) {
		String sql = "insert into Resevation( m_num , c_num , r_dayin , r_dayout , r_plusday, r_totday , r_totprice ) values( ? , ? , ? , ? , ? , ?, ?)";
		try {
			System.out.println("작동체크를 시작합니다");
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, reservation.getM_num());
			preparedStatement.setInt(2, reservation.getC_num());
			preparedStatement.setString(3, reservation.getR_dayin());
			preparedStatement.setString(4, reservation.getR_dayout());
			preparedStatement.setString(5, "0");
			preparedStatement.setString(6, reservation.getR_totday());
			preparedStatement.setString(7, reservation.getR_totprice());
			preparedStatement.executeUpdate();
			System.out.println("작동체크를 시작합니다");
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	// 예약수정 메소드
	public boolean update(int r_num, int c_num, String r_dayin, String r_dayout, String r_plusday, String r_totday,
			String r_totprice) {

		// reservation 테이블 번호를 기준 조건으로 찾아서 업데이트를 하는 것임
		String sql = "update Resevation set c_num=? , r_dayin=? , r_dayout=? , r_plusday=? , r_totday=? , r=totprice=? where r_num = ?"; // 업데이트
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, r_num);
			preparedStatement.setInt(3, c_num);
			preparedStatement.setString(4, r_dayin);
			preparedStatement.setString(5, r_dayout);
			preparedStatement.setString(6, r_plusday);
			preparedStatement.setString(7, r_totday);
			preparedStatement.setString(8, r_totprice);
			preparedStatement.executeUpdate(); // sql 갱신
			return true;
		} catch (Exception e) {

		}
		return false;
	}

	// 예약조회리스트 메소드
	public ObservableList<Reservation> reservelist() {

		ObservableList<Reservation> reservations = FXCollections.observableArrayList();

		// 0 . 리스트 선언
		ArrayList<Reservation> arrayList = new ArrayList<Reservation>();

		// 1. 조건 없이 모두 가져오기

		String sql = "select * from Resevation order by r_num desc"; // 전부 가져옴 해당 값을 desc 즉 내림차순으로 가져오는것
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			// 2.
			while (resultSet.next()) {
				// 쿼리 결과내 레코드가 없을때 까지 반복
				Reservation reservation = new Reservation ( 
						resultSet.getInt(1), 
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getInt(7),
						resultSet.getInt(8)
						);
						
				// 객체를 리스트에 담기
				
				reservations.add(reservation);
				System.out.println("출력2" + reservations );
			}
			return reservations;
		} catch (Exception e) {
		}
		return reservations; // 객체선언 reservation 에서 가져온 reservations를 반환
	}
	
	public int r_numcount() {

		String sql = "SELECT count(*) FROM ezen.Resevation";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;

	}

	// 렌트 삭제
	

//	// 예약리스트 조회?
//	public ObservableList<Car> carsearch(Car car2) {
//		ObservableList<Car> cars = FXCollections.observableArrayList();
//		
//		String sql = 
//		
//		System.out.println("오류체크 cardao carsearch");
//		try {
//			preparedStatement = connection.prepareStatement(sql);
//			System.out.println(car2.getC_name() + "안녕하세요2");
//			preparedStatement.setString(1, car2.getC_name() + "%");
//			System.out.println(car2.getC_ct1() + "안녕하세요2");
//			preparedStatement.setString(2, car2.getC_ct1() + "%");
//			preparedStatement.setString(3, car2.getC_ct2() + "%");
//			preparedStatement.setString(4, car2.getC_ct3() + "%");
//			
//			System.out.println(car2.getC_name() + "안녕하세요");
//			resultSet = preparedStatement.executeQuery();
//			System.out.println("오류체크 cardao  carsearch asdasd");
//			while(resultSet.next()) {
//				Car car= new Car(
//						resultSet.getInt(1),    
//						resultSet.getString(2), 
//						resultSet.getString(3), 
//						resultSet.getInt(4),    
//						resultSet.getString(5), 
//						resultSet.getString(6), 
//						resultSet.getString(7), 
//						resultSet.getBoolean(8) 
//				);
//				
//				cars.add(car);
//				System.out.println("오류체크 cardao  carsearch12" + car);
//				System.out.println("오류체크 cardao  carsearch2" + cars);
//			}
//			return cars;
//			
//		}catch (Exception e) {
//			// TODO: handle exception
//		}return cars;
//	}
} // C E
