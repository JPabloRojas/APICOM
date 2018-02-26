package cl.apicom.spring.backend.auxentities;

public class DetailClientDateModel {
	long id;
	long ot;
	String nomina;
	String tipo;
	String cliente;
	String estado;
	String destinatario;
	String direccion;
	long idpar;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getOt() {
		return ot;
	}
	public void setOt(long ot) {
		this.ot = ot;
	}
	public String getNomina() {
		return nomina;
	}
	public void setNomina(String nomina) {
		this.nomina = nomina;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public long getIdpar() {
		return idpar;
	}
	public void setIdpar(long idpar) {
		this.idpar = idpar;
	}
}
