package cl.apicom.spring.backend.auxentities;

import java.util.List;

import cl.apicom.spring.backend.entities.User;


/*
 * Modelo de respuesta para plantillas.
 */
public class List_data {
	
	private List<User> data;

	public List<User> getData() {
		return data;
	}

	public void setData(List<User> data) {
		this.data = data;
	}
}
