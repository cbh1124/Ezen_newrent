package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {

	private Connection connection;
	private PreparedStatement preparedStatement; 
	private ResultSet resultSet;
	
	public MemberDao() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimezone=UTC", "root","1234");
		}catch (Exception e) { System.out.println("db연동 실패");}	
	}
	public boolean login() {
		
		String sql = "select * from"
	}
}
