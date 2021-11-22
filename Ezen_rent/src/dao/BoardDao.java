package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import controller.boardcontroller.ReplywriteController;
import domain.Board;
import domain.Reply;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

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
	
	// Q&A(board2) 게시물 등록 메소드
	public boolean board2write(Board board) {
		String sql = "insert into Board(b_title, b_contents, m_num, b_type, c_num) values(?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, board.getB_title());
			preparedStatement.setString(2, board.getB_contents());
			preparedStatement.setInt(3, board.getM_num());  // 멤버 넘버로 조회후 아이디 찾아야됨 
			preparedStatement.setString(4, "2");
			preparedStatement.setInt(5, 1);
			preparedStatement.executeUpdate();
			return true;
			
		}catch (Exception e) {System.out.println("저장실패");	}
		return false;
	}
	
	
	// 공지사항(board1) 게시물 등록 메소드
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
	// 공지사항(borad1) 게시물 조회 
	public ObservableList<Board> board1list(){
		ObservableList<Board> boards1 = FXCollections.observableArrayList();
		
		String sql = "select * from Board where b_type = 1 order by b_num desc";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while( resultSet.next()) {
				Board board = new Board(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5));
				
				boards1.add(board);
			}
			return boards1;
		} catch (Exception e) {} return boards1;
		
	}
	// Q&A(borad2) 게시물 조회 
		public ObservableList<Board> board2list(){
			ObservableList<Board> boards2 = FXCollections.observableArrayList();
			
			String sql = "select * from Board where b_type = 2 order by b_num desc";
			
			try {
				preparedStatement = connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				
				while( resultSet.next()) {
					Board board = new Board(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)
							, resultSet.getInt(5), resultSet.getString(6),resultSet.getInt(7),resultSet.getInt(8));
					boards2.add(board);
				}
				return boards2;
			} catch (Exception e) {} return boards2;
			
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
	
	public String getmid (int m_num) {
		String sql = "select m_id from Member where m_num = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, m_num);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				
				return resultSet.getString(1);
			}else {
				return "";
			}
		} catch (Exception e) {} return "";
	}
	
	// 댓글등록 메소드
	public boolean replywrite( Reply reply ) {
		
		String sql = "insert into Reply(br_contents, b_num, m_num) values(?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, reply.getBr_contents());
			preparedStatement.setInt(2, reply.getb_num());
			preparedStatement.setInt(3, reply.getM_num());
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {}return false;
	}
	
	//댓글 리스트
	public ObservableList<Reply> replylist(int b_num) {
		
		ObservableList<Reply> replys = FXCollections.observableArrayList();
		String sql = "select * from Reply where b_num = ? order by br_num desc";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, b_num);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Reply reply = new Reply(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5));
				replys.add(reply);
			}
			return replys;
		} catch (Exception e) {} return replys;
	}
	// 조회수 업데이트
	public boolean viewupdate( int b_num) {
		
		String sql = "update Board set b_view = b_view+1 where b_num = ?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, b_num);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return false;
	}
	// 게시판2 수정
	public boolean board2update(int b_num, String b_title, String b_contents) {
		
		String sql = "update Board set b_title = ?, b_contents = ?, where b_num = ?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, b_title);
			preparedStatement.setString(2, b_contents);
			preparedStatement.setInt(3, b_num);
			return true;
		} catch (Exception e) {} return false;
		
	}
	// 게시판2 삭제
	public boolean boarddelete(int b_num) {
		
		String sql = "delete from Board where b_num = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, b_num);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {} return false;
	}
	// 조인을 통한 예약 넘버 및 예약된 차량의 넘버 조회 
	public ObservableList<Board> write3( int m_num ) {
		
		ObservableList<Board> boards = FXCollections.observableArrayList();
		
		String sql = "select Resevation.r_num, Car.c_name"
				+ " from Resevation join Car "
				+ "on Resevation.c_num = Car.c_num where m_num = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, m_num);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				// 쿼리 결과내 레코드가 없을때 까지 반복 
				Board board = new Board(resultSet.getInt(1), 
								  resultSet.getString(2)
				);
				System.out.println( board );
				boards.add(board);
			}
			System.out.println("출력이 되시나요??1");
			return boards;
		}
		catch (Exception e) {
			
		} return boards;
		
		
	}
	

	//myinfo QnA 출력
	public ObservableList<Board> myinfoboard2list(int m_num){
		ObservableList<Board> boards2 = FXCollections.observableArrayList();
		
		String sql = "select * from Board where b_type = 2 and m_num = ? order by b_num desc";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, m_num);
			resultSet = preparedStatement.executeQuery();
			
			while( resultSet.next()) {
				Board board = new Board(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)
						, resultSet.getInt(5), resultSet.getString(6),resultSet.getInt(7),resultSet.getInt(8));
				boards2.add(board);
			}
			return boards2;
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} return boards2;
	}
	
	public int b_numcount() {

		String sql = "SELECT count(*) FROM ezen.Board;";
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
