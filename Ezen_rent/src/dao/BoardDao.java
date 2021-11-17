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

	// 1. �ʵ� /
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	//��ü 
	private static BoardDao boardDao = new BoardDao();
	
	public BoardDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://goldcon2.hopto.org:3309/ezen?serverTimezone=UTC",  
					"root" , "1234");
			System.out.println(" db ���� ����");
		}
		catch (Exception e) {
			System.out.println(" * DB ���� ���� : " + e);
		}
	}
	// ��ü ��ȯ �޼ҵ� 
	public static BoardDao getboardDao() {return boardDao;}
	
	public boolean board1write(Board board) {
		String sql = "insert into Board(b_title, b_contents, m_num, b_type, c_num) values(?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, board.getB_title());
			preparedStatement.setString(2, board.getB_contents());
			preparedStatement.setInt(3, board.getM_num());  // ��� �ѹ��� ��ȸ�� ���̵� ã�ƾߵ� 
			preparedStatement.setString(4, "1");
			preparedStatement.setInt(5, 1);
			preparedStatement.executeUpdate();
			return true;
			
		}catch (Exception e) {
			
		}
		return false;
	}
	
		//  �Խù� ��� �޼ҵ� 
	public boolean write(Board board) {
		String sql = "insert into Board(b_title, b_contents, b_num, c_num) values(?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, board.getB_title());
			preparedStatement.setString(2, board.getB_contents());
			preparedStatement.setInt(3, board.getM_num());  // ��� �ѹ��� ��ȸ�� ���̵� ã�ƾߵ� 
			preparedStatement.setInt(4, board.getC_num());  // ī �ѹ��� ��ȸ �� �ڵ��� ��ƾߵ� 
			preparedStatement.executeUpdate();
			return true;
			
		}catch (Exception e) {
			
		}
		return false;
	}
	
		// �Խù� ��ȸ �޼ҵ� 
	public ObservableList<Board> boardlist( ){
		
		ObservableList<Board> boards = FXCollections.observableArrayList();
		
		// 0 . ����Ʈ ���� 
		ArrayList<Board> arrayList = new ArrayList<Board>();
		
		// 1. ���� ���� ��� �������� 
		/*int b_num, String b_title, String b_contents, String b_date, int b_view, int b_type, int m_num, int c_num)*/
		String sql = "select * from Board order by b_no desc"; // ���� ������ �ش� ���� desc �� ������������ �������°�
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			// 2. 
			while(resultSet.next()){
				// ���� ����� ���ڵ尡 ������ ���� �ݺ� 
				Board board = new Board(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)
						, resultSet.getInt(5), resultSet.getString(6),resultSet.getInt(7),resultSet.getInt(8));
				// ��ü�� ����Ʈ�� ��� 
				boards.add(board);	
			}
			return boards;
		}catch (Exception e) {} return boards;    //��ü���� board���� ������ boards�� ��ȯ 
	}

	// �Խù� ���� �޼ҵ�  // �μ����� no�� �ִ� ���� ? sql ���ǹ��� no�� ��ȸ�� �Ͽ� �����ϱ� ����
	public boolean viewdelete( int b_no ) {
		// ������ �� Ȯ���ؾߵ� ????????????????????????????????????????????????????????????????????????????????!!
		// �Խù� ������ ��ۿ� ���� ���� ���� db�� ��������ߵ� ������� ������ �� ���ٰ�!!(11_15���� �������� �ȵǾ����� 16�� ���ͽ� �ۼ��� ��)
		String sql = "delete from Board where b_no = ?";  
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, b_no); 
			preparedStatement.executeUpdate(); // sql ����
			return true;
		} catch (Exception e) {
			
		}return false;
		
	}
	
	// �Խù� ���� �޼ҵ� 
	public boolean update(int b_no, String b_title, String b_contents) {
		
		// board ���̺� ��ȣ�� ���� �������� ã�Ƽ� ������Ʈ�� �ϴ� ���� 
		String sql = "update Board set b_title =?, b_contents =? where b_no = ?"; // ������Ʈ 
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(3, b_no);
			preparedStatement.setString(1, b_title);
			preparedStatement.setString(2, b_contents);
			preparedStatement.executeUpdate(); // sql ����
			return true;
		} catch (Exception e) {
			
		}return false;
	}
	
	
	
	
	
	
	
	
	
	
	
}
