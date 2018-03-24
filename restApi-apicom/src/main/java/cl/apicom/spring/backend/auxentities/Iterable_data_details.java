package cl.apicom.spring.backend.auxentities;

import cl.apicom.spring.backend.entities.Detail;


/*
 * Modelo de respuesta para plantillas.
 */
public class Iterable_data_details {
	
	private Iterable<Detail> data;

	public Iterable<Detail> getData() {
		return data;
	}

	public void setData(Iterable<Detail> data) {
		this.data = data;
	}
}
