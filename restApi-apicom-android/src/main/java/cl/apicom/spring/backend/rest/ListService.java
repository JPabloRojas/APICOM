package cl.apicom.spring.backend.rest;

import java.io.IOException;
import java.sql.Timestamp;

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
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.auxentities.RequestID;
import cl.apicom.spring.backend.auxentities.RequestSingleData;
import cl.apicom.spring.backend.entities.Lista;
import cl.apicom.spring.backend.entities.User;
import cl.apicom.spring.backend.repository.ListRepository;
import cl.apicom.spring.backend.repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/list")
public class ListService {
	
	@Autowired
	private ListRepository listrepository;
	
	@Autowired
	private UserRepository userrepository;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Lista> getAllLists(){
		return listrepository.findAll();
	}
	
	
	/*@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public void addList(@RequestBody RequestSingleData resource, HttpServletResponse response) throws IOException{
		User u = userrepository.findbyUser(resource.getData());
		if(u == null){
			response.sendError(400);
		}
		else{
			Lista list = new Lista();
			list.setId_user(u.getId());
			 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			list.setList_date(timestamp);
			list.setPrice(0);
			try{
				listrepository.save(list);
				response.setStatus(201);
			}
			catch(DataIntegrityViolationException e){
				response.sendError(400);
			}
		}
	}*/
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getListUser(@PathVariable("id") long id){
		User user = userrepository.findOne(id);
		if(user == null){
			String jsonResponse = "{\"response\":400,\"desc\":\"Id usuario no existe\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			try{
				Iterable<Lista> listas = listrepository.getListUser(id);
				return ResponseEntity.status(HttpStatus.OK).body(listas);
			}
			catch(Exception e){
				String jsonResponse = "{\"response\":400,\"desc\":"+e.toString()+"}";
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}
		}
	}
	
	
	
}
