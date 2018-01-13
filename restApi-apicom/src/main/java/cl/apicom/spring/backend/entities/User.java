package cl.apicom.spring.backend.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="apicom_users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "user_name", unique = false, nullable = false)
	private String user_name;
	
	@Column(name = "user", unique = true, nullable = false)
	private String user;
	
	@Column(name = "password", unique = true, nullable = false)
	private String password;
	
	@Column(name = "creation_date", unique = false, nullable = false)
	private Timestamp creation_date;
	
	@Column(name = "last_change_date", unique = false, nullable = true)
	private Timestamp last_change_date;
	
	@Column(name = "mail", unique = false, nullable = false)
	private String mail;
	
	@Column(name = "active", unique = false, nullable = false)
	private int active;
	
	@ManyToOne
	@JoinColumn(name = "id_client", insertable = false, updatable = false)
	@JsonIgnore
	private Client client;
	
	@Column(name = "id_client", unique = false, nullable = false)
	private int id_client;
	
	@Column(name = "profile", unique = false, nullable = false)
	private int profile;
	
	@Column(name = "payment_status", unique = false, nullable = false)
	private int payment_status;
	
	@Column(name = "payment_type", unique = false, nullable = false)
	private int payment_type;
	
	@Column(name = "patente_vehiculo", unique = true, nullable = false)
	private String patente_vehiculo;

	
	
	public int getId() {
		return id;
	}
	
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCreation_date() {
		return creation_date.toString();
	}

	public void setCreation_date(Timestamp creation_date) {
		this.creation_date = creation_date;
	}

	public String getLast_change_date() {
		String response;
		if(last_change_date != null){
			response = last_change_date.toString();
		}
		else{
			response = "null";
		}
		
		return response;
	}

	public void setLast_change_date(Timestamp last_change_date) {
		this.last_change_date = last_change_date;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public int getProfile() {
		return profile;
	}

	public void setProfile(int profile) {
		this.profile = profile;
	}

	public int getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(int payment_status) {
		this.payment_status = payment_status;
	}

	public int getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(int payment_type) {
		this.payment_type = payment_type;
	}

	public String getPatente_vehiculo() {
		return patente_vehiculo;
	}

	public void setPatente_vehiculo(String patente_vehiculo) {
		this.patente_vehiculo = patente_vehiculo;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
}
