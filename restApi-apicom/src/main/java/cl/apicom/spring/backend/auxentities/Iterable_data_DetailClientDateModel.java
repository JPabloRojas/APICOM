package cl.apicom.spring.backend.auxentities;

import java.util.List;

/*
 * Modelo de respuesta para plantillas
 */
public class Iterable_data_DetailClientDateModel {
	
	List<DetailClientDateModel> data;

	public List<DetailClientDateModel> getData() {
		return data;
	}

	public void setData(List<DetailClientDateModel> data) {
		this.data = data;
	}
}
