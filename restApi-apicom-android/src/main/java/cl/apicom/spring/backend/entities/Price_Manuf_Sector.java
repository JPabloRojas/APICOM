package cl.apicom.spring.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="apicom_price_manuf_sector")
@NamedQuery(name="Price_Manuf_Sector.findAll", query="SELECT pms FROM Price_Manuf_Sector pms")
public class Price_Manuf_Sector {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "id_sector", unique = false, nullable = false)
	private long id_sector;
	
	@Column(name = "id_manufacture", unique = false, nullable = false)
	private long id_manufacture;
	
	@Column(name = "price", unique = false, nullable = false)
	private int price;
	
	@Column(name = "active", unique = false, nullable = false)
	private int active;
	
	
	public long getId() {
		return id;
	}
	public long getId_sector() {
		return id_sector;
	}

	public void setId_sector(long id_sector) {
		this.id_sector = id_sector;
	}

	public long getId_manufacture() {
		return id_manufacture;
	}
	public void setId_manufacture(long id_manufacture) {
		this.id_manufacture = id_manufacture;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	
	
	
}
