package cl.apicom.spring.backend.auxentities;


/*
 * Modelo de respuesta para servicios GET de comunas con id y respectivo nombre
 */
public class ComunasModel {
	
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
