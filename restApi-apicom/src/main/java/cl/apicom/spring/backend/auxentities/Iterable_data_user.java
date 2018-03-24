package cl.apicom.spring.backend.auxentities;

import java.util.List;

import cl.apicom.spring.backend.entities.User;


/*
 * Modelo de respuesta para plantillas.
 */
public class Iterable_data_user {
	
	private List<UserModel> data;

	public List<UserModel> getData() {
		return data;
	}

	public void setData(List<UserModel> data) {
		this.data = data;
	}
	
}
