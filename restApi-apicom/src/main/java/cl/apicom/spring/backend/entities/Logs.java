package cl.apicom.spring.backend.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="apicom_logs")
@NamedQuery(name="Logs.findAll", query="SELECT lg FROM Logs lg")
public class Logs {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "id_user", unique = false, nullable = false)
	private int id_user;
	
	@Column(name = "date", unique = false, nullable = false)
	private Timestamp date;
	
	@Column(name = "action", unique = false, nullable = false)
	private String action;
	
	@Column(name = "ip", unique = false, nullable = false)
	private String ip;

	//Duda con campos extra
	
	public int getId() {
		return id;
	}
	
	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getDate() {
		return date.toString();
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	
}
