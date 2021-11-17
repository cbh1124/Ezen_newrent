package domain;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Member {
	
	private int m_no;
	private String m_id;
	private String m_password;
	private String m_name;
	private String m_email;
	private String m_dob;
	private String m_phone;
	
	public Member() {
	//
	}
	// 회원가입 생성자
	public Member(String m_id, String m_password, String m_name, String m_email, String m_dob, String m_phone) {
		this.m_id = m_id;
		this.m_password = m_password;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_dob = m_dob;
		this.m_phone = m_phone;
	}
	
	public Member(String m_id, String m_name, String m_email, String m_phone) {
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_email = m_email;
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

	public String getM_dob() {
		return m_dob;
	}

	public void setM_dob(String m_dob) {
		this.m_dob = m_dob;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	
	
	public static void sendmail(String tomail, String msg, int type) {
		//
		String fromemail = "아이디"; // 실제 
		String frompassword = "비밀번호"; // 실제
		
		Properties properties = new Properties();
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host","smtp.naver.com");
		properties.put("mail.smtp.port","587");
		properties.put("mail.smtp.auth","true");
		
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromemail, frompassword);
			}
		});
		// 메일보내기
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromemail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(tomail));
			
			message.setSubject("회원님의 비밀번호 조회 결과");
			message.setText("회원님의 비밀번호는  : " + msg);
			
			Transport.send(message);
		} catch (Exception e) {}
	}
}
