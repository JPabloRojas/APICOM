package cl.apicom.spring.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="apicom_sector")
@NamedQuery(name="Sector.findAll", query="SELECT s FROM Sector s")
public class Sector {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "delimitation", unique = false, nullable = false)
	private String delimitation;
	
	@Column(name = "active", unique = false, nullable = false)
	private String active;

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDelimitation() {
		return delimitation;
	}

	public void setDelimitation(String delimitation) {
		this.delimitation = delimitation;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	
	
	
	
}
