package cl.apicom.spring.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="apicom_price_client_sector")
@NamedQuery(name="Price_Client_Sector.findAll", query="SELECT pcs FROM Price_Client_Sector pcs")
public class Price_Client_Sector {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "id_cliente", unique = false, nullable = false)
	private int id_cliente;
	
	@Column(name = "id_manufacture", unique = false, nullable = false)
	private int id_manufacture;
	
	@Column(name = "id_sector", unique = false, nullable = false)
	private int id_sector;
	
	@Column(name = "price", unique = false, nullable = false)
	private int price;

	@Column(name = "active", unique = false, nullable = false)
	private int active;
	
	public int getId() {
		return id;
	}
	
	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_product() {
		return id_manufacture;
	}

	public void setId_product(int id_manufacture) {
		this.id_manufacture = id_manufacture;
	}

	public int getId_sector() {
		return id_sector;
	}

	public void setId_sector(int id_sector) {
		this.id_sector = id_sector;
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
