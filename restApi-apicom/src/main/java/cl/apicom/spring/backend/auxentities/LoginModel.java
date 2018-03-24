package cl.apicom.spring.backend.auxentities;


/*
 * Modelo de respuesta para servicios tipo GET/POST que requieran la visualizacion o requisito de datos
 * tipo user y password de un respectivo usuario.
 */
public class LoginModel {
	
	private String user;
	private String password;
	
	
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
}
