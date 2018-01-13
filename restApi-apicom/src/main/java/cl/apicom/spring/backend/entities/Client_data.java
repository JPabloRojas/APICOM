package cl.apicom.spring.backend.entities;

import java.util.List;

public class Client_data {
	private static final long serialVersionUID = 1L;
	
	private List<User> data;

	public List<User> getData() {
		return data;
	}

	public void setData(List<User> data) {
		this.data = data;
	}
}
