package cl.apicom.spring.backend.auxentities;


/*
 * Modelo de respuesta para servicios tipo GET que impliquen el requerimiento de id, nombre y estado de actividad
 * de un usuario.
 */
public class UserProfileModel {
	
	private long id;
	private String name;
	private int active;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
}
