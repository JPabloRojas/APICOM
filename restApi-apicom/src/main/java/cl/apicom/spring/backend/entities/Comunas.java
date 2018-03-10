package cl.apicom.spring.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="apicom_comunas")
@NamedQuery(name="Comunas.findAll", query="SELECT c FROM Comunas c")
public class Comunas {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "comuna", unique = false, nullable = false)
	private String comuna;
	
	@Column(name = "dir", unique = false, nullable = false)
	private int dir;
	
	@Column(name = "zona", unique = false, nullable = false)
	private String zona;

	public long getId() {
		return id;
	}
	
	public String getNombre() {
		return comuna;
	}

	public void setNombre(String comuna) {
		this.comuna = comuna;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}
}
