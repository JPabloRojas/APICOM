package cl.apicom.spring.backend.auxentities;


/*
 * Modelo de mapeo de datos JSON para respuesta de funcionalidad login.
 */
public class LoginResponseModel {
	
	private long id;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
