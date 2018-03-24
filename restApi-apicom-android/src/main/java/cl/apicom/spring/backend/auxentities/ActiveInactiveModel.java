package cl.apicom.spring.backend.auxentities;


/*
 * Modelo de mapeo de datos JSON para funcionalidad de activar y desactivar lista.
 */

public class ActiveInactiveModel {
	
	private long id;
	private int active;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
}
