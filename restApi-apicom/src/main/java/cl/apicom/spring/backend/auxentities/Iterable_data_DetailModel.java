package cl.apicom.spring.backend.auxentities;

import java.util.List;


/*
 * Modelo de respuesta para plantillas.
 */
public class Iterable_data_DetailModel {
	private List<DetailModel> data;

	public List<DetailModel> getData() {
		return data;
	}

	public void setData(List<DetailModel> data) {
		this.data = data;
	}
}
