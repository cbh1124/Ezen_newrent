package domain;

public class Car {
	
	private String c_num;
	private String c_license;
	private String c_img;
	private String c_price;
	private String c_ct1;
	private String c_ct2;
	private String c_ct3;
	private boolean ret;
	
	// ±øÅë
	public Car() {
		
	}
	
	// ¸ðµç
	public Car(String c_num, String c_license, String c_img, String c_price, String c_ct1, String c_ct2, String c_ct3,
			boolean ret) {
		this.c_num = c_num;
		this.c_license = c_license;
		this.c_img = c_img;
		this.c_price = c_price;
		this.c_ct1 = c_ct1;
		this.c_ct2 = c_ct2;
		this.c_ct3 = c_ct3;
		this.ret = ret;
	}

	//
	public Car(String c_num, String c_license, String c_img, String c_price, String c_ct1, String c_ct2, String c_ct3) {
		super();
		this.c_num = c_num;
		this.c_license = c_license;
		this.c_img = c_img;
		this.c_price = c_price;
		this.c_ct1 = c_ct1;
		this.c_ct2 = c_ct2;
		this.c_ct3 = c_ct3;
	}

	public String getC_num() {
		return c_num;
	}

	public void setC_num(String c_num) {
		this.c_num = c_num;
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

	public String getC_price() {
		return c_price;
	}

	public void setC_price(String c_price) {
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

	public boolean isRet() {
		return ret;
	}

	public void setRet(boolean ret) {
		this.ret = ret;
	}
	
	
	
}
