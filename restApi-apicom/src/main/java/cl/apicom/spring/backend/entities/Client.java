package cl.apicom.spring.backend.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="apicom_client")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "creation_date", unique = false, nullable = false)
	private Timestamp creation_date;
	
	@Column(name = "active", unique = false, nullable = false)
	private int active;
		
	@Column(name = "contact", unique = false, nullable = false)
	private String contact;
	
	@Column(name = "phone", unique = true, nullable = false)
	private String phone;
	
	@Column(name = "mail", unique = true, nullable = false)
	private String mail;
	
	@Column(name = "rut", unique = true, nullable = false)
	private String rut;
	
	@Column(name = "adress", unique = false, nullable = false)
	private String adress;
	
	@OneToMany(mappedBy = "client")
	private List<User> user_list;
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreation_date() {
		return creation_date.toString();
	}

	public void setCreation_date(Timestamp creation_date) {
		this.creation_date = creation_date;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public List<User> getUser_list() {
		return user_list;
	}

	public void setUser_list(List<User> user_list) {
		this.user_list = user_list;
	}

	
	
	
	
	
}
