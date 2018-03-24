package cl.apicom.spring.backend.auxentities;

/*
 * Modelo de mapeo de datos JSON para servicios que requieren uso de ID.
 */
public class RequestID {
	
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
