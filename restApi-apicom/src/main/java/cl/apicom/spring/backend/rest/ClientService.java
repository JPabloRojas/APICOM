package cl.apicom.spring.backend.rest;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.auxentities.Iterable_data_client;
import cl.apicom.spring.backend.auxentities.List_data;
import cl.apicom.spring.backend.entities.Client;
import cl.apicom.spring.backend.entities.User;
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
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllClients(){
		
		Iterable_data_client  idc = new Iterable_data_client();
		idc.setData(clientrepository.findAll());
		return ResponseEntity.status(HttpStatus.OK).body(idc);
		
	}
	/*
	 * Plataforma: Administrador
	 * Tipo: GET
	 * Descripcion: Obtiene los datos de un cliente
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getClient(@PathVariable("id") long id){
		Client c = clientrepository.findOne(id);
		if(c == null){
			String jsonResponse = "{\"response\":400,\"desc\":\"Id de cliente no encontrado\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			List<Client> cl = new ArrayList<Client>();
			cl.add(c);
			return ResponseEntity.status(HttpStatus.OK).body(cl);
		}
	}
	
	/*
	 * Plataforma: Administrador
	 * Tipo: GET
	 * Descripcion: Obtiene todos los usuarios relacionados con un cliente
	 */
	@RequestMapping(value = "/data/users/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllClientsData(@PathVariable("id") long id){
		try{
			List<User> user_list = clientrepository.findOne(id).getUser_list();
			List_data cwd = new List_data();
			cwd.setData(user_list);
			return ResponseEntity.status(HttpStatus.OK).body(cwd);
		}
		catch(NullPointerException e){
			String jsonResponse = "{\"response\":400,\"desc\":\"Id de cliente no encontrado\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
	}
	
	
	/*
	 * Plataforma: Administrador
	 * Tipo: Post
	 * Descripcion: Crea un cliente, inserta en la BD
	 */
	@RequestMapping(value = "/new/{name}/{contact}/{phone}/{mail}/{rut}/{adress}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addClient(@PathVariable("name") String name,@PathVariable("contact") String contact, @PathVariable("phone") String phone, @PathVariable("mail") String mail, @PathVariable("rut") String rut, @PathVariable("adress") String adress){
			
		
		Client client = new Client();
		client.setName(name);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		client.setCreation_date(timestamp);
		client.setActive(1);
		client.setContact(contact);
		client.setPhone(phone);
		client.setMail(mail);
		client.setRut(rut);
		client.setAdress(adress);	
		try{
			clientrepository.save(client);
			String jsonResponse = "{\"response\":201}";
			return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse);
		}
		catch(DataIntegrityViolationException e){
			String jsonResponse = "{\"response\":400,\"desc\":\"No se ha podido crear el cliente\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		
		
	}
	/*
	 * Plataforma: Administrador
	 * Tipo: PUT
	 * Descripcion: Actualiza datos de un lciente
	 */
	@RequestMapping(value = "/update/{id}/{name}/{contact}/{phone}/{mail}/{rut}/{adress}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<?> updateClient(@PathVariable("id") long id, @PathVariable("name") String name,@PathVariable("contact") String contact, @PathVariable("phone") String phone, @PathVariable("mail") String mail, @PathVariable("rut") String rut, @PathVariable("adress") String adress){
		
		Client client = clientrepository.findOne(id);
		if(client == null){
			String jsonResponse = "{\"response\":400,\"desc\":\"Id cliente no existe\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			client.setName(name);
			client.setContact(contact);
			client.setPhone(phone);
			client.setMail(mail);
			client.setRut(rut);
			client.setAdress(adress);
			try{
				clientrepository.save(client);
				String jsonResponse = "{\"response\":200}";
				return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
			}
			catch(DataIntegrityViolationException e){
				String jsonResponse = "{\"response\":400,\"desc\":\"No se ha podido actualizar informacion\"}";
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}

		}
	}
	
	/*
	 * Plataforma: Administrador
	 * Tipo: PUT
	 * Descripcion: Activa/Desactiva un cliente
	 */
	@RequestMapping(value = "/inactive/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> inactiveUser(@PathVariable("id") long id){
		Client client = clientrepository.findOne(id);
		if(client == null){
			String jsonResponse = "{\"response\":400,\"desc\":\"Id cliente no existe\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			int active = client.getActive();
			if(active == 1){
				try{
					client.setActive(0);
					clientrepository.save(client);
					String jsonResponse = "{\"response\":200}";
					return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
				}
				catch(DataIntegrityViolationException e){
					String jsonResponse = "{\"response\":400,\"desc\":\"No se ha podido cambiar el estado\"}";
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
				}
			}
			else{
				try{
					client.setActive(1);
					clientrepository.save(client);
					String jsonResponse = "{\"response\":200}";
					return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
				}
				catch(DataIntegrityViolationException e){
					String jsonResponse = "{\"response\":400,\"desc\":\"No se ha podido cambiar el estado\"}";
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
				}
			}
		}
	}
	
}
