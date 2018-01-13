package cl.apicom.spring.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="apicom_gps")
@NamedQuery(name="Gps.findAll", query="SELECT g FROM Gps g")
public class Gps {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "latitude", unique = false, nullable = false)
	private double latitude;
	
	@Column(name = "longitude", unique = false, nullable = false)
	private double longitude;
	
	@Column(name = "id_user", unique = false, nullable = false)
	private int id_user;

	public int getId() {
		return id;
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
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

}
