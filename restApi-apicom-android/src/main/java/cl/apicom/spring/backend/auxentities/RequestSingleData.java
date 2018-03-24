package cl.apicom.spring.backend.auxentities;


/*
 * Modelo de mapeo de datos JSON para servicios que requieren del uso de un dato tipo String.
 */
public class RequestSingleData {
	
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
