package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.Car;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CarDao {

	// 1. �ʵ�
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	// 1-1. ��ü
	public static CarDao carDao=new CarDao(){};

	// 2. ������
	public CarDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://goldcon2.hopto.org:3309/ezen?serverTimezone=UTC",
					"root", "1234");
		} catch (Exception e) {
		}
	}

	// 3. �޼ҵ�

	// ��ü��ȯ�޼ҵ�
	public static CarDao getCarDao() {
		return carDao;
	}

	// 3-1. ���� ���
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

	// 3-2. �������
	public ObservableList<Car> carlist() {
		// 1. ����Ʈ���� 
		ObservableList<Car> cars = FXCollections.observableArrayList();
		String sql = "select c_num, c_name,c_license, c_price,c_ct1,c_ct2,c_ct3,c_return from Car order by c_num desc"; // �� ��������
		System.out.println("����ã��");
		try {
			preparedStatement = connection.prepareStatement(sql);
			System.out.println("����ã��");
			resultSet = preparedStatement.executeQuery();
			System.out.println("����ã��");
			while( resultSet.next() ) { // �˻���� ���ڵ尡 ���������� ���ڵ� �ϳ��� ��ȯ
				// �ش� ���ڵ带 ��üȭ
				Car car = new Car(resultSet.getInt(1), 
						resultSet.getString(2), 
						resultSet.getString(3), 
						resultSet.getInt(4), 
						resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getString(7),
						resultSet.getBoolean(8)
						
						);
				System.out.println("����ã��" +  car);
				// ��ü ����Ʈ ���� 
				cars.add(car);
				System.out.println(cars);
			}
			return cars;
		} catch (Exception e) {} return cars;
		
	}

	// 3-2. ��������
	public boolean delete( int c_num ) {
		String sql = "delete from Car where c_no =? ";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, c_num);
			preparedStatement.executeUpdate();
			return true;
		}
		catch (Exception e) {} return false;
	}
	
	// 3-3. ��������
	public boolean update( Car car ) {
		String sql = "update Car set c_name=?, c_license=?, c_ct=?, c_img=?, c_price=?, c_ct1=?, c_ct2=?, c_ct3=?, c_return=? where c_num=?";
		
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
		} catch (Exception e) {} return false;
	}
	
	
	//
	// 3-2. �������
	public ObservableList<Car> carlist3() {
		// 1. ����Ʈ���� 
		ObservableList<Car> cars = FXCollections.observableArrayList();
		String sql = "select c_num, c_name,c_ct1,c_ct2,c_ct3,c_price from Car order by c_num desc"; // �� ��������
		System.out.println("����ã��");
		try {
			preparedStatement = connection.prepareStatement(sql);
			System.out.println("����ã��");
			resultSet = preparedStatement.executeQuery();
			System.out.println("����ã��");
			while( resultSet.next() ) { // �˻���� ���ڵ尡 ���������� ���ڵ� �ϳ��� ��ȯ
				// �ش� ���ڵ带 ��üȭ
				Car car = new Car(resultSet.getInt(1), 
						resultSet.getString(2), 
						resultSet.getString(3), 
						resultSet.getString(4), 
						resultSet.getString(5),
						resultSet.getInt(6)
						);
				System.out.println("����ã��" +  car);
				// ��ü ����Ʈ ���� 
				cars.add(car);
				System.out.println(cars);
			}
			return cars;
		} catch (Exception e) {} return cars;
		
	}


}
