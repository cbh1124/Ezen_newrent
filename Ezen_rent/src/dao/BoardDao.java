package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import domain.Board;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BoardDao {

	// 1. 필드 /
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	//객체 
	private static BoardDao boardDao = new BoardDao();
	
	public BoardDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://goldcon2.hopto.org:3309/ezen?serverTimezone=UTC",  
					"root" , "1234");
			System.out.println(" db 연동 성공");
		}
		catch (Exception e) {
			System.out.println(" * DB 연동 실패 : " + e);
		}
	}
	// 객체 반환 메소드 
	public static BoardDao getboardDao() {return boardDao;}
	
	public boolean board1write(Board board) {
		String sql = "insert into Board(b_title, b_contents, m_num, b_type, c_num) values(?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, board.getB_title());
			preparedStatement.setString(2, board.getB_contents());
			preparedStatement.setInt(3, board.getM_num());  // 멤버 넘버로 조회후 아이디 찾아야됨 
			preparedStatement.setString(4, "1");
			preparedStatement.setInt(5, 1);
			preparedStatement.executeUpdate();
			return true;
			
		}catch (Exception e) {
			
		}
		return false;
	}
	
		//  게시물 등록 메소드 
	public boolean write(Board board) {
		String sql = "insert into Board(b_title, b_contents, b_num, c_num) values(?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, board.getB_title());
			preparedStatement.setString(2, board.getB_contents());
			preparedStatement.setInt(3, board.getM_num());  // 멤버 넘버로 조회후 아이디 찾아야됨 
			preparedStatement.setInt(4, board.getC_num());  // 카 넘버로 조회 후 자동차 잦아야됨 
			preparedStatement.executeUpdate();
			return true;
			
		}catch (Exception e) {
			
		}
		return false;
	}
	
		// 게시물 조회 메소드 
	public ObservableList<Board> boardlist( ){
		
		ObservableList<Board> boards = FXCollections.observableArrayList();
		
		// 0 . 리스트 선언 
		ArrayList<Board> arrayList = new ArrayList<Board>();
		
		// 1. 조건 없이 모두 가져오기 
		/*int b_num, String b_title, String b_contents, String b_date, int b_view, int b_type, int m_num, int c_num)*/
		String sql = "select * from Board order by b_no desc"; // 전부 가져옴 해당 값을 desc 즉 내림차순으로 가져오는것
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			// 2. 
			while(resultSet.next()){
				// 쿼리 결과내 레코드가 없을때 까지 반복 
				Board board = new Board(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)
						, resultSet.getInt(5), resultSet.getString(6),resultSet.getInt(7),resultSet.getInt(8));
				// 객체를 리스트에 담기 
				boards.add(board);	
			}
			return boards;
		}catch (Exception e) {} return boards;    //객체선언 board에서 가져온 boards를 반환 
	}

	// 게시물 삭제 메소드  // 인수값을 no로 주는 이유 ? sql 조건문에 no로 조회를 하여 삭제하기 위해
	public boolean viewdelete( int b_no ) {
		// 문제점 꼭 확인해야됨 ????????????????????????????????????????????????????????????????????????????????!!
		// 게시물 삭제시 댓글에 대한 연쇄 삭제 db를 설정해줘야됨 연쇄삭제 설정을 꼭 해줄것!!(11_15일자 기준으로 안되어있음 16일 복귀시 작성할 듯)
		String sql = "delete from Board where b_no = ?";  
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, b_no); 
			preparedStatement.executeUpdate(); // sql 갱신
			return true;
		} catch (Exception e) {
			
		}return false;
		
	}
	
	// 게시물 수정 메소드 
	public boolean update(int b_no, String b_title, String b_contents) {
		
		// board 테이블 번호를 기준 조건으로 찾아서 업데이트를 하는 것임 
		String sql = "update Board set b_title =?, b_contents =? where b_no = ?"; // 업데이트 
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(3, b_no);
			preparedStatement.setString(1, b_title);
			preparedStatement.setString(2, b_contents);
			preparedStatement.executeUpdate(); // sql 갱신
			return true;
		} catch (Exception e) {
			
		}return false;
	}
	
	
	
	
	
	
	
	
	
	
	
}
