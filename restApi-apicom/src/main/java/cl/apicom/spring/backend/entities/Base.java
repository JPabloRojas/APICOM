package cl.apicom.spring.backend.entities;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="apicom_base")
@NamedQuery(name="Base.findAll", query="SELECT b FROM Base b")
public class Base {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "id_user", unique = false, nullable = false)
	private long id_user;
	
	@Column(name = "date", unique = false, nullable = false)
	private Timestamp date;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;

	@Column(name = "sales_check", unique = false, nullable = false)
	private int sales_check;
	
	public long getId() {
		return id;
	}

	public long getId_user() {
		return id_user;
	}

	public void setId_user(long id_user) {
		this.id_user = id_user;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSales_check() {
		return sales_check;
	}

	public void setSales_check(int sales_check) {
		this.sales_check = sales_check;
	}
	
	
}
