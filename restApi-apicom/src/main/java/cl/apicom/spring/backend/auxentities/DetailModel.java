package cl.apicom.spring.backend.auxentities;

public class DetailModel {
	
	private long id_paquete;
	private long ot;
	private String tipo;
	private String cliente;
	private String estado;
	
	public long getId_paquete() {
		return id_paquete;
	}
	public void setId_paquete(long id_paquete) {
		this.id_paquete = id_paquete;
	}
	public long getOt() {
		return ot;
	}
	public void setOt(long ot) {
		this.ot = ot;
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
}
