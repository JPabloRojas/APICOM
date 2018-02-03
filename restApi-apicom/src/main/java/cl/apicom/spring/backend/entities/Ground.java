package cl.apicom.spring.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="apicom_ground")
@NamedQuery(name="Ground.findAll", query="SELECT g FROM Ground g")
public class Ground {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "estate", unique = false, nullable = false)
	private String estate;
	
	@Column(name = "mobility", unique = false, nullable = false)
	private String mobility;
	
	@Column(name = "patente", unique = false, nullable = false)
	private String patente;
	
	@OneToOne(mappedBy = "ground")
	private User user;
	
	public long getId() {
		return id;
	}

	public String getEstate() {
		return estate;
	}

	public void setEstate(String estate) {
		this.estate = estate;
	}

	public String getMobility() {
		return mobility;
	}

	public void setMobility(String mobility) {
		this.mobility = mobility;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
