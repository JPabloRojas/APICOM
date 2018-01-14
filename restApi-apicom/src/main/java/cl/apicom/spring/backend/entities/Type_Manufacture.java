package cl.apicom.spring.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="apicom_type_manufacture")
@NamedQuery(name="Type_Manufacture.findAll", query="SELECT tm FROM Type_Manufacture tm")
public class Type_Manufacture {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "description", unique = true, nullable = false)
	private String description;
	
	@Column(name = "active", unique = true, nullable = false)
	private int active;

	public int getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
}
