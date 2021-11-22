package domain;

public class Reply {

	private int br_num;
	private String br_contents;
	private String br_date;
	private int b_num;
	private int m_num;
	
	public Reply() {
	
	}

	public Reply(int br_num, String br_contents, String br_date, int b_num, int m_num) {
		this.br_num = br_num;
		this.br_contents = br_contents;
		this.br_date = br_date;
		this.b_num = b_num;
		this.m_num = m_num;
	}
	
	
	
	public Reply(String br_contents, int b_num, int m_num) {
		this.br_contents = br_contents;
		this.b_num = b_num;
		this.m_num = m_num;
	}

	public Reply(String br_contents) {
		this.br_contents = br_contents;
	}

	public int getBr_num() {
		return br_num;
	}

	public void setBr_num(int br_num) {
		this.br_num = br_num;
	}

	public String getBr_contents() {
		return br_contents;
	}

	public void setBr_contents(String br_contents) {
		this.br_contents = br_contents;
	}

	public String getBr_date() {
		return br_date;
	}

	public void setBr_date(String br_date) {
		this.br_date = br_date;
	}

	public int getb_num() {
		return b_num;
	}

	public void setb_num(int b_num) {
		this.b_num = b_num;
	}

	public int getM_num() {
		return m_num;
	}

	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	
	
	
}
