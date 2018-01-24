package cl.apicom.spring.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.entities.Client;
import cl.apicom.spring.backend.repository.ClientRepository;



@CrossOrigin
@RestController
@RequestMapping("/client")
public class ClientService {
	
	@Autowired
	private ClientRepository clientrepository;
	
	
	/*
	 * Plataforma: Administrador
	 * Tipo: GET
	 * Descripcion: Obtiene todos los clientes del sistema
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllClients(){
		try{
			Iterable<Client> clients = clientrepository.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(clients);
		}
		catch(Exception e){
			String jsonResponse = "{\"response\":400,\"desc\":\"No se han podido obtener los clientes\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		
	}
}
