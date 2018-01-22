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

import cl.apicom.spring.backend.auxentities.Id_client_model;
import cl.apicom.spring.backend.auxentities.Iterable_data_client;
import cl.apicom.spring.backend.auxentities.List_data;
import cl.apicom.spring.backend.auxentities.UserModel;
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
		try{
			Iterable_data_client  idc = new Iterable_data_client();
			idc.setData(clientrepository.findAll());
			return ResponseEntity.status(HttpStatus.OK).body(idc);
		}
		catch(Exception e){
			String jsonResponse = "{\"response\":400,\"desc\":\"No se han podido obtener los clientes\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		
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
			List<UserModel> lu = new ArrayList<UserModel>();
			for(User u: user_list){
				UserModel umAux = new UserModel();
				umAux.setId(u.getId());
				umAux.setUser_name(u.getUser_name());
				umAux.setUser(u.getUser());
				umAux.setPassword(u.getPassword());
				umAux.setCreation_date(u.getCreation_date());
				umAux.setLast_change_date(u.getLast_change_date());
				umAux.setMail(u.getMail());
				umAux.setActive(u.getActive());
				umAux.setClient_name(u.getClient().getName());
				umAux.setId_client(u.getId_client());
				umAux.setId_profile(u.getId_profile());
				umAux.setPayment_status(u.getPayment_status());
				umAux.setPayment_type(u.getPayment_type());
				umAux.setPatente_vehiculo(u.getPatente_vehiculo());
				lu.add(umAux);
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(lu);
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
	@ResponseBody
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
	
	
	/*
	 * Plataforma: Administrador
	 * Tipo: GET
	 * Descripcion: Obtiene modelo id - nombre cliente
	 */
	@RequestMapping(value = "/IdName", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getIdName(){
		try{
			List<Id_client_model> icm = new ArrayList<>();
			Iterable<Client> clients = clientrepository.findAll();
			for(Client c: clients){
				Id_client_model icmAux = new Id_client_model();
				icmAux.setId(c.getId());
				icmAux.setNombre(c.getName());
				icm.add(icmAux);
			}
			return ResponseEntity.status(HttpStatus.OK).body(icm);
		}
		catch(Exception e){
			String jsonResponse = "{\"response\":400,\"desc\":\"No se ha podido obtener la lista de clientes\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
