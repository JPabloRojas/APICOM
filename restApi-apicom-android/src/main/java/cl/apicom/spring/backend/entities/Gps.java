package cl.apicom.spring.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="apicom_gps")
@NamedQuery(name="Gps.findAll", query="SELECT g FROM Gps g")
public class Gps {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "id_user", unique = false, nullable = false)
	private long id_user;
	
	@Column(name = "latitude", unique = false, nullable = false)
	private double latitude;
	
	@Column(name = "longitude", unique = false, nullable = false)
	private double longitude;
	
	@ManyToOne
	@JoinColumn(name = "id_user", insertable = false, updatable = false)
	@JsonIgnore
	private User user_gps;
	
	public long getId() {
		return id;
	}
	
	public long getId_user() {
		return id_user;
	}
	public void setId_user(long id_user) {
		this.id_user = id_user;
	}
	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public User getUser_gps() {
		return user_gps;
	}
	public void setUser_gps(User user_gps) {
		this.user_gps = user_gps;
	}

}
