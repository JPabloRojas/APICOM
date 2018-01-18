package cl.apicom.spring.backend.auxentities;

public class UserUpdateModel {
	
	private String id;
	private String user_name;
	private String user;
	private String password;
	private String mail;
	private int id_client;
	private int profile;
	private String payment_type;
	private String patente_vehiculo;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public int getProfile() {
		return profile;
	}
	public void setProfile(int profile) {
		this.profile = profile;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public String getPatente_vehiculo() {
		return patente_vehiculo;
	}
	public void setPatente_vehiculo(String patente_vehiculo) {
		this.patente_vehiculo = patente_vehiculo;
	}
}
