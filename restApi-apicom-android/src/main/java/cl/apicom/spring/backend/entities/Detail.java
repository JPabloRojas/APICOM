package cl.apicom.spring.backend.entities;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="apicom_detail")
@NamedQuery(name="Detail.findAll", query="SELECT d FROM Detail d")
public class Detail {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "id_manufacture", unique = false, nullable = false)
	private long id_manufacture;
	
	@Column(name = "id_pair", unique = false, nullable = false)
	private long id_pair;
	
	@Column(name = "estate", unique = false, nullable = false)
	private int estate;
	
	@Column(name = "estate_date", unique = false, nullable = true)
	private Timestamp estate_date;
	
	@Column(name = "despair_date", unique = false, nullable = false)
	private Timestamp despair_date;
	
	@Column(name = "ingress_date", unique = false, nullable = false)
	private Timestamp ingress_date;
	
	
	@ManyToOne
	@JoinColumn(name = "id_lista", insertable = false, updatable = false)
	@JsonIgnore
	private Lista lista;
	
	@Column(name = "id_lista", unique = false, nullable = false)
	private long id_lista;
	
	@Column(name = "id_base", unique = false, nullable = false)
	private long id_base;
	
	@Column(name = "iata", unique = false, nullable = false)
	private long iata;

	public long getId() {
		return id;
	}

	public long getId_manufacture() {
		return id_manufacture;
	}

	public void setId_manufacture(long id_manufacture) {
		this.id_manufacture = id_manufacture;
	}

	public long getId_pair() {
		return id_pair;
	}

	public void setId_pair(long id_pair) {
		this.id_pair = id_pair;
	}

	public int getEstate() {
		return estate;
	}

	public void setEstate(int estate) {
		this.estate = estate;
	}

	public Timestamp getEstate_date() {
		return estate_date;
	}

	public void setEstate_date(Timestamp estate_date) {
		this.estate_date = estate_date;
	}

	public Timestamp getDespair_date() {
		return despair_date;
	}

	public void setDespair_date(Timestamp despair_date) {
		this.despair_date = despair_date;
	}

	public Timestamp getIngress_date() {
		return ingress_date;
	}

	public void setIngress_date(Timestamp ingress_date) {
		this.ingress_date = ingress_date;
	}

	public long getId_lista() {
		return id_lista;
	}

	public void setId_lista(long id_lista) {
		this.id_lista = id_lista;
	}

	public long getId_base() {
		return id_base;
	}

	public void setId_base(long id_base) {
		this.id_base = id_base;
	}

	public long getIata() {
		return iata;
	}

	public void setIata(long iata) {
		this.iata = iata;
	}

	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}

}