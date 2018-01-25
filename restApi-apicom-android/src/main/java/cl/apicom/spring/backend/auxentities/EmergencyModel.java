package cl.apicom.spring.backend.auxentities;

import java.sql.Timestamp;

public class EmergencyModel {
	private long id_user;
	private String type;
	private String description;
	private Timestamp date;
	private String phone;
	private Iterable<Long> ids_detalles;
	public long getId_user() {
		return id_user;
	}
	public void setId_user(long id_user) {
		this.id_user = id_user;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Iterable<Long> getIds_detalles() {
		return ids_detalles;
	}
	public void setIds_detalles(Iterable<Long> ids_detalles) {
		this.ids_detalles = ids_detalles;
	}
}
