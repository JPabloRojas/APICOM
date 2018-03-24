package cl.apicom.spring.backend.auxentities;

/*
 * Modelo de respuesta/requerimiento de datos en donde solo se implique un dato tipo String.
 */
public class RequestSingleData {
	
	private String data;

	public String getData() {
		return data;
	}

	public void setdata(String data) {
		this.data = data;
	}
}
