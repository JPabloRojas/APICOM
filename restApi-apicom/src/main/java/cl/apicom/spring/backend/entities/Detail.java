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
	
	//wea
	@Column(name = "id_manufacture", unique = false, nullable = false)
	private long id_manufacture;
	
	@Column(name = "id_pair", unique = false, nullable = false)
	private long id_pair;
	
	@Column(name = "estate", unique = false, nullable = false)
	private int estate;
	
	@Column(name = "estate_date", unique = false, nullable = false)
	private Timestamp estate_date;
	
	@Column(name = "despair_date", unique = false, nullable = false)
	private Timestamp despair_date;
	
	@Column(name = "ingress_date", unique = false, nullable = false)
	private Timestamp ingress_date;
	
	@Column(name = "id_lista", unique = false, nullable = false)
	private long id_lista;
	
	@Column(name = "id_base", unique = false, nullable = false)
	private long id_base;
	
	@Column(name = "iata", unique = false, nullable = false)
	private long iata;
	
}
