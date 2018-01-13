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
	private long id;
	
	@Column(name = "id_cliente", unique = false, nullable = false)
	private long id_cliente;
	
	@Column(name = "id_product", unique = false, nullable = false)
	private long id_product;
	
	@Column(name = "id_sector", unique = false, nullable = false)
	private long id_sector;
	
	@Column(name = "price", unique = false, nullable = false)
	private int price;

	public long getId() {
		return id;
	}
	
	public long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public long getId_product() {
		return id_product;
	}

	public void setId_product(long id_product) {
		this.id_product = id_product;
	}

	public long getId_sector() {
		return id_sector;
	}

	public void setId_sector(long id_sector) {
		this.id_sector = id_sector;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
