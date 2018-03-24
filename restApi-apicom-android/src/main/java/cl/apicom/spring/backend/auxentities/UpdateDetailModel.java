package cl.apicom.spring.backend.auxentities;


/*
 * Modelo de mapeo de datos JSON para servicios servicio que requiere actualicion del estado de un Detalle.
 */
public class UpdateDetailModel {
	
	private long id;
	private int state;
	private String comment;
	private String receptor;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getReceptor() {
		return receptor;
	}
	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}
}
