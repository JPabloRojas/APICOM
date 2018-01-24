package cl.apicom.spring.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="apicom_gps_last")
@NamedQuery(name="Gps_last.findAll", query="SELECT gl FROM Gps_last gl")
public class Gps_last {
	
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
	
	@OneToOne
	@JoinColumn(name = "id_user", insertable = false, updatable = false)
	@JsonIgnore
	private User user_gps_last;
	
	
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
	
	public User getUser_gps_last() {
		return user_gps_last;
	}

	public void setUser_gps_last(User user_gps_last) {
		this.user_gps_last = user_gps_last;
	}
	
	
}
