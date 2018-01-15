package cl.apicom.spring.backend.auxentities;

public class LoginResponseModel {
	
	private String user_name;
	private String mail;
	
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
}
