package cl.apicom.spring.backend.auxentities;

import cl.apicom.spring.backend.entities.Client;

public class Iterable_data_client {
	
	private Iterable<Client> data;

	public Iterable<Client> getData() {
		return data;
	}

	public void setData(Iterable<Client> data) {
		this.data = data;
	}
}
