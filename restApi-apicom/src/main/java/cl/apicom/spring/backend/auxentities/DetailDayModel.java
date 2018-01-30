package cl.apicom.spring.backend.auxentities;

public class DetailDayModel {
	
	private long id;
	private String nombre;
	private String position;
	private String tipo;
	private int cartas_totales;
	private int cartas_entregadas;
	private int paquetes_totales;
	private int paquetes_entregados;
	private String detalle;
	private String desctipo;
	private String estado;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCartas_totales() {
		return cartas_totales;
	}
	public void setCartas_totales(int cartas_totales) {
		this.cartas_totales = cartas_totales;
	}
	public int getCartas_entregadas() {
		return cartas_entregadas;
	}
	public void setCartas_entregadas(int cartas_entregadas) {
		this.cartas_entregadas = cartas_entregadas;
	}
	public int getPaquetes_totales() {
		return paquetes_totales;
	}
	public void setPaquetes_totales(int paquetes_totales) {
		this.paquetes_totales = paquetes_totales;
	}
	public int getPaquetes_entregados() {
		return paquetes_entregados;
	}
	public void setPaquetes_entregados(int paquetes_entregados) {
		this.paquetes_entregados = paquetes_entregados;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getDesctipo() {
		return desctipo;
	}
	public void setDesctipo(String desctipo) {
		this.desctipo = desctipo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
