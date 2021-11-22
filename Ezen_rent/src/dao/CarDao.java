package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.admincontroller.AdminController;
import domain.Car;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CarDao {

	// 1. 필드
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	// 1-1. 객체
	public static CarDao carDao = new CarDao() {
	};

	// 2. 생성자
	public CarDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://goldcon2.hopto.org:3309/ezen?serverTimezone=UTC",
					"root", "1234");
		} catch (Exception e) {
		}
	}

	// 3. 메소드

	// 객체반환메소드
	public static CarDao getCarDao() {
		return carDao;
	}

	// 3-1. 차량 등록
	public boolean register(Car car) {
		String sql = "insert into Car( c_name, c_license, c_img, c_price, c_ct1, c_ct2, c_ct3, c_return )"
				+ "values(?,?,?,?,?,?,?,?)";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, car.getC_name());
			preparedStatement.setString(2, car.getC_license());
			preparedStatement.setString(3, car.getC_img());
			preparedStatement.setInt(4, car.getC_price());
			preparedStatement.setString(5, car.getC_ct1());
			preparedStatement.setString(6, car.getC_ct2());
			preparedStatement.setString(7, car.getC_ct3());
			preparedStatement.setBoolean(8, car.isC_return());
			preparedStatement.executeUpdate();
			return true;

		} catch (Exception e) {
		}
		return false;
	}

	// 3-2. 차량목록
	public ObservableList<Car> carlist() {
		// 1. 리스트선언
		ObservableList<Car> cars = FXCollections.observableArrayList();
		String sql = "select c_num, c_name,c_license, c_img, c_price,c_ct1,c_ct2,c_ct3,c_return from Car order by c_num desc"; // 다
																														// 가져오기
		System.out.println("오류찾기");
		try {
			preparedStatement = connection.prepareStatement(sql);
			System.out.println("오류찾기");
			resultSet = preparedStatement.executeQuery();
			System.out.println("오류찾기");
			while (resultSet.next()) { // 검색결과 레코드가 없을때까지 레코드 하나씩 반환
				// 해당 레코드를 객체화
				Car car = new Car(resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getInt(5),
						resultSet.getString(6),
						resultSet.getString(7),
						resultSet.getString(8),
						resultSet.getBoolean(9)

				);
				System.out.println("오류찾기30");
				// 객체 리스트 저장
				cars.add(car);
				System.out.println(cars);
			}
			return cars;
		} catch (Exception e) {
		}
		return cars;

	}

	// 3-2. 차량삭제
	public boolean delete(int c_num) {
		String sql = "delete from Car where c_num =?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, c_num);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	// 3-3. 차량수정
	public boolean update(Car car) {
		String sql = "update Car set c_name=?, c_license=?, c_img=?, c_price=?, c_ct1=?, c_ct2=?, c_ct3=?, c_return=? where c_num=?";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, car.getC_name());
			preparedStatement.setString(2, car.getC_license());
			preparedStatement.setString(3, car.getC_img());
			preparedStatement.setInt(4, car.getC_price());
			preparedStatement.setString(5, car.getC_ct1());
			preparedStatement.setString(6, car.getC_ct2());
			preparedStatement.setString(7, car.getC_ct3());
			preparedStatement.setBoolean(8, car.isC_return());
			preparedStatement.setInt(9, AdminController.car.getC_num());
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	// 차량 이미지 링크 조회
	public String carlist2(int num) {
		// 1. 리스트선언
		String sql = "select c_img from Car where c_num=?"; // 다 가져오기

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, num);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString(1); // 넘버값 가져옴
			} else {
				return null; // 결과 없으면
			}

		} catch (Exception e) {
		}
		return null; // DB 오류일 경우

	}

	// 차량 sql 가져오기
	public ObservableList<Car> cartableloading() {
		// 1. 리스트선언
		ObservableList<Car> carloads = FXCollections.observableArrayList();
		String sql = "select c_name, c_img from Car group by c_name"; // 차량 종류별로 다 가져오기
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) { // 검색결과 레코드가 없을때까지 레코드 하나씩 반환
				// 해당 레코드를 객체화
				Car car = new Car(resultSet.getString(1), resultSet.getString(2));
				System.out.println("차량 이미지 sql 가져오기" + carloads.size());
				System.out.println(car);
				// 객체 리스트 저장
				carloads.add(car);
				System.out.println(carloads);
				System.out.println(carloads.size());
			}
			return carloads;
		} catch (Exception e) {
		}
		return carloads;

	}

	public int carno(String name) {
		String sql = "select c_num from Car where c_name=?";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt(1);
			} else {
				return 0; // 결과 없으면
			}

		} catch (Exception e) {

		}
		return 0;
	}
	
	public String carname(int c_num) {
		String sql = "select c_name from Car where c_num=?";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, c_num);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString(1);
			} else {
				return ""; // 결과 없으면
			}

		} catch (Exception e) {

		}
		return "";
	}
	
	public ObservableList<Car> carsearch(Car car2) {
		ObservableList<Car> cars = FXCollections.observableArrayList();
		
		String sql = "select c_num, c_name,c_license, c_price,c_ct1,"
				+ "c_ct2,c_ct3,c_return from Car where c_name like ? and c_ct1 like ? and c_ct2 like ? and c_ct3 like ?";
		
		System.out.println("오류체크 cardao carsearch");
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, car2.getC_name() + "%");
			preparedStatement.setString(2, car2.getC_ct1() + "%");
			preparedStatement.setString(3, car2.getC_ct2() + "%");
			preparedStatement.setString(4, car2.getC_ct3() + "%");
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Car car= new Car(
						resultSet.getInt(1),    
						resultSet.getString(2), 
						resultSet.getString(3), 
						resultSet.getInt(4),    
						resultSet.getString(5), 
						resultSet.getString(6), 
						resultSet.getString(7), 
						resultSet.getBoolean(8) 
				);
				
				cars.add(car);
				
			}
			return cars;
			
		}catch (Exception e) {
			// TODO: handle exception
		}return cars;
	}
	
	public int c_numcount() {

		String sql = "SELECT count(*) FROM ezen.Car";
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

}
