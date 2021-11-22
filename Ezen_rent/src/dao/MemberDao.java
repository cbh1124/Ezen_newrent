package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.Member;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MemberDao {
	//
	private Connection connection;
	private PreparedStatement preparedStatement; 
	private ResultSet resultSet;
	public static boolean adminRs;
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
		
		String sql = "insert into Member(m_id, m_password, m_name, m_dob, m_phone, m_email)" + "values(?, ?, ?, ?, ?, ?)";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, member.getM_id());
			preparedStatement.setString(2, member.getM_password());
			preparedStatement.setString(3, member.getM_name());
			preparedStatement.setString(4, member.getM_dob());
			preparedStatement.setString(5, member.getM_phone());
			preparedStatement.setString(6, member.getM_email());
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("오류");} return false;
		
	}
	//로그인 메소드
	public boolean login(String id, String password) {
		
		String sql = "select * from Member where m_id = ? and m_password = ?";
		
		try {
			adminRs = getAdmin(id, password);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) { return true;	}
			
			else { return false; }
		} catch (Exception e) {System.out.println("로그인오류");} return false;
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
		//
	}
	// 회원탈퇴 
	public boolean delete( String loginid) {
		
		String sql = "delete from Member where m_id = ?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginid);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("오류");} return false;
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
	
	public int getmno(String m_id) {
		
		String sql = "select m_num from Member where m_id = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, m_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}
			else {
				return 0;
			}
		} catch (Exception e) {} return 0;
		
	}
	
	// 어드민 체크 
	public boolean getAdmin(String m_id, String m_password) {
		String sql = "select m_num from Member where m_id = ? and m_password = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, m_id);
			preparedStatement.setString(2, m_password);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				resultSet.getInt(1);
				if(resultSet.getInt(1) == 1 ) { return true; }
				System.out.println(resultSet.getInt(1) +  "작동");
			}
			else { return false; }	
		}
		catch (Exception e) {
			
		} return false;
	}
	
public String getmname(int m_num) {
		
		String sql = "select m_id from Member where m_num = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, m_num);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getString(1);
			}
			else {
				return "";
			}
		} catch (Exception e) {} return "";
		
	}

public int m_numcount() {
	
	String sql = "SELECT count(*) FROM ezen.Menber";
	try {
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		if( resultSet.next() ) {
			return resultSet.getInt(1);
		}
	}catch (Exception e) {} return 0;

}
}
