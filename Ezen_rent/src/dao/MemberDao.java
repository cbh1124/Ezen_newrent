package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.Member;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MemberDao {

	private Connection connection;
	private PreparedStatement preparedStatement; 
	private ResultSet resultSet;
	
	private static MemberDao memberDao = new MemberDao();
	public MemberDao() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://goldcon2.hopto.org:3309/ezen?serverTimezone=UTC", "root","1234");
		}catch (Exception e) { System.out.println("db연동 실패");}	
	}
	
	public static MemberDao getMemberDao() { return memberDao; }
	//회원가입 메소드
	public boolean signup(Member member) {
		
		String sql = "insert into Member(m_id, m_password, m_name, m_email, m_dof, m_phone)" + "values(?, ?, ?, ?, ?, ?)";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, member.getM_id());
			preparedStatement.setString(2, member.getM_password());
			preparedStatement.setString(3, member.getM_name());
			preparedStatement.setString(4, member.getM_email());
			preparedStatement.setString(5, member.getM_dof());
			preparedStatement.setString(6, member.getM_phone());
			preparedStatement.executeLargeUpdate();
			return true;
		} catch (Exception e) {} return false;
		
	}
	//로그인 메소드
	public boolean login(String id, String password) {
		
		String sql = "select * from Member where m_id = ? and m_password = ?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) { return true;	}
			else { return false; }
		} catch (Exception e) {} return false;
	}
	// 아이디 찾기 메소드
	public String findid (String name, String email) {
		
		try {	
			String sql = "select m_id from Member where m_name = ? and m_email = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) { return resultSet.getString(1); }
			else { return null; }
		}catch (Exception e) {} return null;
	}
	// 비밀번호 찾기 메소드
	public String findpassword(String id, String name, String email, String dob, String phone ) {
		String sql = "select m_password from Member where m_id = ? and m_name = ? and "
				+ "m_email = ? and m_dob = ? and m_phone = ?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, dob);
			preparedStatement.setString(5, phone);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) { return resultSet.getString(1); }
			else { return null; }
			
		} catch (Exception e) {} return null;
	}
	// 아이디 체크 메소드
	public boolean idcheck (String id) {
		String sql = "select m_id from Member where m_id = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) { return true; }
			else { return false; }
		} catch (Exception e) {} return true;
	}
	
	public boolean update(String id, String password, String email, String phone) {
		String sql = "update Member set m_password = ?, m_email = ?, m_phone = ? where = m_id = ?";
		
		try {
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, phone);
			preparedStatement.setString(4, id);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {}return false;
		
	}
	// 회원 조회
	public Member getMember(String loginid) {
		
		String sql = "select * from Member where m_id = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginid);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				Member member = new Member(resultSet.getString(2), resultSet.getString(4),
						resultSet.getString(6),resultSet.getString(7));
				return member;
			}else {
				return null;
			}
		} catch (Exception e) {} return null;
	}
	
}
