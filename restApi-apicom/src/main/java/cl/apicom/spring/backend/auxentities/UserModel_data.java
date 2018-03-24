package cl.apicom.spring.backend.auxentities;

import java.util.List;

/*
 * Modelo de respuesta para plantillas.
 */
public class UserModel_data {
	private List<UserModel> data;

	public List<UserModel> getData() {
		return data;
	}

	public void setData(List<UserModel> data) {
		this.data = data;
	}
}
