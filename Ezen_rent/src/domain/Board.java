package domain;

public class Board {
	private int b_num;
	private String b_title;
	private String b_contents;
	private String b_date;
	private int b_view;
	private int b_type;
	private int m_num;
	private int c_num;
	
	// ���� (�� ������ ) 
	public Board() {
		// TODO Auto-generated constructor stub
	}
	
	// ��� �ʵ� �޴� ������ 
	public Board(int b_num, String b_title, String b_contents, String b_date, int b_view, int b_type, int m_num,
			int c_num) {
		this.b_num = b_num;
		this.b_title = b_title;
		this.b_contents = b_contents;
		this.b_date = b_date;
		this.b_view = b_view;
		this.b_type = b_type;
		this.m_num = m_num;
		this.c_num = c_num;
	}
	// �Խù� ��Ͻ� �޴� ������ 
	public Board(String b_title, String b_contents, int m_num, int c_num) {
		this.b_title = b_title;
		this.b_contents = b_contents;
		this.m_num = m_num;  // (�ۼ���)����� �ĺ���ȣ
		this.c_num = c_num;  // (�̿�����)�ڵ��� �ĺ���ȣ
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

	public int getB_type() {
		return b_type;
	}

	public void setB_type(int b_type) {
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
	
	// �Խù� ��Ͻ� �޴� ������
	
	
	
	
	
}