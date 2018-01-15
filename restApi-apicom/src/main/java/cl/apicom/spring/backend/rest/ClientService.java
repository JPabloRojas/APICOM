package cl.apicom.spring.backend.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.entities.Client;
import cl.apicom.spring.backend.entities.Client_data;
import cl.apicom.spring.backend.entities.User;
import cl.apicom.spring.backend.repository.ClientRepository;

@CrossOrigin
@RestController
@RequestMapping("/client")
public class ClientService {
	
	@Autowired
	private ClientRepository clientrepository;
	
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Client> getAllClients(){
		return clientrepository.getAllExceptFirst();
	}
	/*public List<Client> getAllClients(){
		List listRe = new ArrayList();
		Iterable<Client> c = clientrepository.findAll();
		for(Client t: c){
			if(t.getId() != 0){
				listRe.add(t);
			}
		}
		return listRe;
	}
	*/
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUsersClient(@PathVariable("id") Integer id){
		return clientrepository.findOne(id).getUser_list();
	}
	
	
	@RequestMapping(value = "/data/users/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Client_data getAllClientsData(@PathVariable("id") Integer id){
		List<User> user_list = clientrepository.findOne(id).getUser_list();
		Client_data cwd = new Client_data();
		cwd.setData(user_list);
		return cwd;
	}
	
	
}
