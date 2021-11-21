package domain;

public class Car {
	private int c_num;
	private String c_name;
	private String c_license;
	private String c_img;
	private int c_price;
	private String c_ct1;
	private String c_ct2;
	private String c_ct3;
	private boolean c_return;
	
	// 깡통
	public Car() {
		
	}
	
	
	// 전부다
	public Car(int c_num, String c_name, String c_license, String c_img, int c_price, String c_ct1, String c_ct2,
			String c_ct3, boolean c_return) {
		
		this.c_num = c_num;
		this.c_name = c_name;
		this.c_license = c_license;
		this.c_img = c_img;
		this.c_price = c_price;
		this.c_ct1 = c_ct1;
		this.c_ct2 = c_ct2;
		this.c_ct3 = c_ct3;
		this.c_return = c_return;
	}



	// 이름 차량번호판 차량이미지경로 차량 가격 카테고리1 카테고리2 카테고리3 반납여부
	public Car(String c_name, String c_license, String c_img, int c_price, String c_ct1, String c_ct2, String c_ct3,
			boolean c_return) {
		
		this.c_name = c_name;
		this.c_license = c_license;
		this.c_img = c_img;
		this.c_price = c_price;
		this.c_ct1 = c_ct1;
		this.c_ct2 = c_ct2;
		this.c_ct3 = c_ct3;
		this.c_return = c_return;
	}
	
	// 전부다
		public Car(int c_num, String c_name, String c_license, int c_price, String c_ct1, String c_ct2,
				String c_ct3, boolean c_return) {
			
			this.c_num = c_num;
			this.c_name = c_name;
			this.c_license = c_license;
			
			this.c_price = c_price;
			this.c_ct1 = c_ct1;
			this.c_ct2 = c_ct2;
			this.c_ct3 = c_ct3;
			this.c_return = c_return;
		}
		
	public Car(String c_name, String c_img) {
		this.c_name = c_name;
		this.c_img = c_img;
	}
	
	public Car(String c_name, String c_ct1, String c_ct2, String c_ct3) {
		this.c_name = c_name;
		this.c_ct1 = c_ct1;
		this.c_ct2 = c_ct2;
		this.c_ct3 = c_ct3;
	}
	
	
	

	public int getC_num() {
		return c_num;
	}



	public void setC_num(int c_num) {
		this.c_num = c_num;
	}



	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_license() {
		return c_license;
	}
	public void setC_license(String c_license) {
		this.c_license = c_license;
	}
	public String getC_img() {
		return c_img;
	}
	public void setC_img(String c_img) {
		this.c_img = c_img;
	}
	public int getC_price() {
		return c_price;
	}
	public void setC_price(int c_price) {
		this.c_price = c_price;
	}
	public String getC_ct1() {
		return c_ct1;
	}
	public void setC_ct1(String c_ct1) {
		this.c_ct1 = c_ct1;
	}
	public String getC_ct2() {
		return c_ct2;
	}
	public void setC_ct2(String c_ct2) {
		this.c_ct2 = c_ct2;
	}
	public String getC_ct3() {
		return c_ct3;
	}
	public void setC_ct3(String c_ct3) {
		this.c_ct3 = c_ct3;
	}
	public boolean isC_return() {
		return c_return;
	}
	public void setC_return(boolean c_return) {
		this.c_return = c_return;
	}

	
	
	




	
	
	
	
	

	
}
	
