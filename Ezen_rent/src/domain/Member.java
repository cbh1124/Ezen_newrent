package domain;

import java.util.Properties;

public class Member {

	private String m_id;
	private String m_password;
	private String m_name;
	private String m_email;
	private String m_dof;
	private String m_phone;
	
	public Member() {
	//
	}
	// 회원가입 생성자
	public Member(String m_id, String m_password, String m_name, String m_email, String m_dof, String m_phone) {
		this.m_id = m_id;
		this.m_password = m_password;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_dof = m_dof;
		this.m_phone = m_phone;
	}
	
	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_dof() {
		return m_dof;
	}

	public void setM_dof(String m_dof) {
		this.m_dof = m_dof;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	//
//	public static void senmail(String tomail, String msg, int type) {
//		
//		String fromemail = "아이디"; // 실제 
//		String frompassword = "패스워드"; // 실제
//		
//		Properties properties = new Properties();
//		properties.put
//	}
	
}
