package cl.apicom.spring.backend.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="apicom_list")
@NamedQuery(name="Lista.findAll", query="SELECT l FROM Lista l")
public class Lista {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "id_user", insertable = false, updatable = false)
	@JsonIgnore
	private User user_list;
	
	@Column(name = "id_user", unique = false, nullable = false)
	private long id_user;
	
	@Column(name = "price", unique = false, nullable = false)
	private int price;
	
	@Column(name = "list_date", unique = false, nullable = false)
	private Timestamp list_date;
	
	@Column(name = "active", unique = false, nullable = false)
	private int active;
	
	@OneToMany(mappedBy = "lista")
	private List<Detail> detail_list;
	
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

	public String getList_date() {
		return list_date.toString();
	}
	
	public void setList_date(Timestamp list_date) {
		this.list_date = list_date;
	}

	public List<Detail> getDetail_list() {
		return detail_list;
	}

	public void setDetail_list(List<Detail> detail_list) {
		this.detail_list = detail_list;
	}

	public User getUser_list() {
		return user_list;
	}

	public void setUser_list(User user_list) {
		this.user_list = user_list;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	





	
	
	
}
