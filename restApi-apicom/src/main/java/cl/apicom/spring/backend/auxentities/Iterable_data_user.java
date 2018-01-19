package cl.apicom.spring.backend.auxentities;

import cl.apicom.spring.backend.entities.User;

public class Iterable_data_user {
	
	private Iterable<User> data;

	public Iterable<User> getData() {
		return data;
	}

	public void setData(Iterable<User> data) {
		this.data = data;
	}
	
}
