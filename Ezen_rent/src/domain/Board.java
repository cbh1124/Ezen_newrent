package domain;

import dao.BoardDao;
import dao.MemberDao;

public class Board {
	private int b_num;
	private String b_title;
	private String b_contents;
	private String b_date;
	private int b_view;
	private String b_type;
	private int m_num;
	private int c_num;
	private String b_writer;
	
	// 임시 생성필드 
	private int r_num;
	private String c_name;
	
	// 깡통 (빈 생성자 ) 
	public Board() {
		// TODO Auto-generated constructor stub
	}
	
	// 모든 필드 받는 생성자 
	public Board(int b_num, String b_title, String b_contents, String b_date, int b_view, String b_type, int m_num,	int c_num) {
		this.b_num = b_num;
		this.b_title = b_title;
		this.b_contents = b_contents;
		this.b_date = b_date;
		this.b_view = b_view;
		this.b_type = b_type;
		this.m_num = m_num;
		this.c_num = c_num;
				
		
	}
	
	// 게시물 등록시 받는 생성자 
	public Board(String b_title, String b_contents, int m_num, int c_num) {
		this.b_title = b_title;
		this.b_contents = b_contents;
		this.m_num = m_num;  // (작성자)등록자 식별번호
		this.c_num = c_num;  // (이용차량)자동차 식별번호
	}
	
	
	
	// 공지사항 게시물 등록시
	public Board(String b_title, String b_contents, int m_num, String b_type, int c_num) {
		this.b_title = b_title;
		this.b_contents = b_contents;
		this.m_num = m_num;
		this.b_type = b_type;
		this.c_num = c_num;
	}
	// 공지사항 게시물 조회
	public Board(int b_num, String b_title, String b_contents, String b_date, int b_view ) {
		this.b_num = b_num;
		this.b_title = b_title;
		this.b_contents = b_contents;
		this.b_date = b_date;
		this.b_view = b_view;
	}
	
	public Board(int r_num, String c_name) {
		this.r_num = r_num;
		this.c_name = c_name;
	}
	
	
	public int getR_num() {
		return r_num;
	}

	public void setR_num(int r_num) {
		this.r_num = r_num;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public int getB_num() {
		return b_num;
	}

	public void setB_num(int b_num) {
		this.b_num = b_num;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_contents() {
		return b_contents;
	}

	public void setB_contents(String b_contents) {
		this.b_contents = b_contents;
	}

	public String getB_date() {
		return b_date;
	}

	public void setB_date(String b_date) {
		this.b_date = b_date;
	}

	public int getB_view() {
		return b_view;
	}

	public void setB_view(int b_view) {
		this.b_view = b_view;
	}

	public String getB_type() {
		return b_type;
	}

	public void setB_type(String b_type) {
		this.b_type = b_type;
	}

	public int getM_num() {
		return m_num;
	}

	public void setM_num(int m_num) {
		this.m_num = m_num;
	}

	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public String getB_writer() {
		return b_writer;
	}

	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	
	// 게시물 등록시 받는 생성자
	
	
	
	
	
}
