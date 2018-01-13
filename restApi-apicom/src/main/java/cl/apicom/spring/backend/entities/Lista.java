package cl.apicom.spring.backend.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="apicom_list")
@NamedQuery(name="Lista.findAll", query="SELECT l FROM Lista l")
public class Lista {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "id_user", unique = false, nullable = false)
	private long id_user;
	
	@Column(name = "price", unique = false, nullable = false)
	private int price;
	
	@Column(name = "list_date", unique = false, nullable = false)
	private Timestamp list_date;

	
	public long getId() {
		return id;
	}
	
	public long getId_user() {
		return id_user;
	}

	public void setId_user(long id_user) {
		this.id_user = id_user;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Timestamp getList_date() {
		return list_date;
	}

	public void setList_date(Timestamp list_date) {
		this.list_date = list_date;
	}


	
	
	
}
