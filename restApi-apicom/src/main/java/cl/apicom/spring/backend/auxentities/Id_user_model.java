package cl.apicom.spring.backend.auxentities;


/*
 * Modelo de respuesta para servicios GET que requieran el id y nombre de un respectivo usuario.
 */
public class Id_user_model {

	private long id;
	private String nombre;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
