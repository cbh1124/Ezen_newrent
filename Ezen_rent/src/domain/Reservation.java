package domain;

import dao.CarDao;
import dao.MemberDao;

public class Reservation {

	//1. 필드
	private int r_num;
	private int m_num;
	private int c_num;
	private String r_dayin;
	private String r_dayout;
	private String r_plusday;
	private String r_totday;
	private String r_totprice;
	
	// 임시
	private String m_name;
	private String c_name;
	
	
	// 2. 생성자
	
	/* 빈생성자 */
	public Reservation () {};
	
	//진짜 전체 생성자
	public Reservation(int r_num, int m_num, int c_num, String r_dayin, String r_dayout, String r_plusday,
			String r_totday, String r_totprice, String m_name, String c_name) {
		super();
		this.r_num = r_num;
		this.m_num = m_num;
		this.c_num = c_num;
		this.r_dayin = r_dayin;
		this.r_dayout = r_dayout;
		this.r_plusday = r_plusday;
		this.r_totday = r_totday;
		this.r_totprice = r_totprice;
		this.m_name = m_name;
		this.c_name = c_name;
	}
	
	/* 전체생성자 */
	public Reservation(int r_num, String r_dayin, String r_dayout, String r_plusday, String r_totday, String r_totprice, int m_num, int c_num  ) {
		super();
		this.r_num = r_num;
		this.r_dayin = r_dayin;
		this.r_dayout = r_dayout;
		this.r_plusday = r_plusday;
		this.r_totday = r_totday;
		this.r_totprice = r_totprice;
		this.m_num = m_num;
		this.c_num = c_num;
	}
	

	// 예약등록시 생성자 : 확인필요
	public Reservation(int r_num, String r_dayin, String r_dayout, String r_plusday, String r_totday, String r_totprice,
			int c_num) {
		
		this.r_num = r_num;
		this.r_dayin = r_dayin;
		this.r_dayout = r_dayout;
		this.r_plusday = r_plusday;
		this.r_totday = r_totday;
		this.r_totprice = r_totprice;
		this.c_num = c_num;
	}	

	//r_num m_num c_license  r_inday r_outday r_totday r_totprice 
	public Reservation(int r_num, int m_num, int c_num, String r_dayin, String r_dayout, String r_totday, String r_totprice) {
		this.r_num = r_num;
		this.m_num = m_num;
		this.c_num = c_num;
		this.r_dayin = r_dayin;
		this.r_dayout = r_dayout;
		this.r_totday = r_totday;
		this.r_totprice = r_totprice;
	}
	

	public Reservation(int c_num, String r_dayin, String r_dayout, String r_plusday, String r_totday, String r_totprice,
			String m_name, String c_name) {
		
		this.c_num = c_num;
		this.r_dayin = r_dayin;
		this.r_dayout = r_dayout;
		this.r_plusday = r_plusday;
		this.r_totday = r_totday;
		this.r_totprice = r_totprice;
		this.m_name = m_name;
		this.c_name = c_name;
	}
	

	public Reservation(int r_num, int m_num, int c_num, String r_dayin, String r_dayout, String r_plusday,
			String r_totday, String r_totprice) {
		
		this.r_num = r_num;
		this.m_num = m_num;
		this.c_num = c_num;
		this.r_dayin = r_dayin;
		this.r_dayout = r_dayout;
		this.r_plusday = r_plusday;
		this.r_totday = r_totday;
		this.r_totprice = r_totprice;
	}

	// 3. 메소드 Gitter / Setter
	public int getR_num() {
		return r_num;
	}

	

	public void setR_num(int r_num) {
		this.r_num = r_num;
	}

	public String getR_dayin() {
		return r_dayin;
	}

	public void setR_dayin(String r_dayin) {
		this.r_dayin = r_dayin;
	}

	public String getR_dayout() {
		return r_dayout;
	}

	public void setR_dayout(String r_dayout) {
		this.r_dayout = r_dayout;
	}

	public String getR_plusday() {
		return r_plusday;
	}

	public void setR_plusday(String r_plusday) {
		this.r_plusday = r_plusday;
	}

	public String getR_totday() {
		return r_totday;
	}

	public void setR_totday(String r_totday) {
		this.r_totday = r_totday;
	}

	public String getR_totprice() {
		return r_totprice;
	}

	public void setR_totprice(String r_totprice) {
		this.r_totprice = r_totprice;
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
	
	
	
	
	
	
	
	
	
	
}
