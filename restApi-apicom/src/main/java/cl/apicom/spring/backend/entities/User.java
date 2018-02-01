package cl.apicom.spring.backend.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="apicom_users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "user_name", unique = false, nullable = false)
	private String user_name;
	
	@Column(name = "user", unique = true, nullable = false)
	private String user;
	
	@Column(name = "password", unique = false, nullable = false)
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
	private long id_client;
	
	@Column(name = "id_profile", unique = false, nullable = false)
	private long id_profile;
	
	@Column(name = "payment_status", unique = false, nullable = false)
	private int payment_status;
	
	@Column(name = "payment_type", unique = false, nullable = false)
	private String payment_type;
	
	@Column(name = "patente_vehiculo", unique = true, nullable = false)
	private String patente_vehiculo;
	
	@Column(name = "id_ground", unique = true, nullable = false)
	private long id_ground;
	
	//Relacion posible al usar en un historial, por el momento no se considera.
	/*@OneToMany(mappedBy = "user_gps")
	private List<Gps> gps_user;*/
	
	@OneToMany(mappedBy = "user_list")
	private List<Lista> list_user;
	
	@OneToOne(mappedBy = "user_gps_last")
	private Gps_last last_gps_user;
	
	@ManyToOne
	@JoinColumn(name = "id_profile", insertable = false, updatable = false)
	@JsonIgnore
	private Profile profile;
	
	public long getId() {
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
	
	public Timestamp getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Timestamp creation_date) {
		this.creation_date = creation_date;
	}

	public Timestamp getLast_change_date() {
		return last_change_date;
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

	public long getId_client() {
		return id_client;
	}

	public void setId_client(long id_client) {
		this.id_client = id_client;
	}

	public long getId_profile() {
		return id_profile;
	}

	public void setId_profile(long id_profile) {
		this.id_profile = id_profile;
	}
	
	public int getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(int payment_status) {
		this.payment_status = payment_status;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
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

	/*public List<Gps> getGps_user() {
		return gps_user;
	}

	public void setGps_user(List<Gps> gps_user) {
		this.gps_user = gps_user;
	}*/

	public List<Lista> getList_user() {
		return list_user;
	}

	public void setList_user(List<Lista> list_user) {
		this.list_user = list_user;
	}

	public Gps_last getLast_gps_user() {
		return last_gps_user;
	}

	public void setLast_gps_user(Gps_last last_gps_user) {
		this.last_gps_user = last_gps_user;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public long getId_ground() {
		return id_ground;
	}

	public void setId_ground(long id_ground) {
		this.id_ground = id_ground;
	}

	
	
	
}
