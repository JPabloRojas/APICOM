package cl.apicom.spring.backend.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.entities.User;
import cl.apicom.spring.backend.repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserService {
	
	@Autowired
	private UserRepository userrepository;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<User> getAllUsers(){
		return userrepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	//@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void create(@RequestBody User resource ,HttpServletResponse response) throws IOException{
		//userrepository.save(resource);
		try{
			userrepository.save(resource);
			response.setStatus(200);
		}
		catch(DataIntegrityViolationException e){
			response.sendError(465, "No se pudo insertar en la BD");
		}
		
	}
	

	@RequestMapping(value = "test/{num}", method = RequestMethod.GET)
	@ResponseBody
	public void test(@PathVariable("num") Integer num, HttpServletResponse response) throws IOException{
		//ResponseEntity en;
		if(num == 1){
			//en =  new ResponseEntity(HttpStatus.ACCEPTED);
			//response.sendError(666);
			//response.setStatus(666,"message");
			response.sendError(666, "hola men");
		}
		else if(num == 2){
			//en =  new ResponseEntity(HttpStatus.BAD_GATEWAY);
			//response.sendError(668);
			response.setStatus(200);
		}
		else{
			//en = new ResponseEntity(HttpStatus.);
			response.sendError(669);
		}
		
	}
}
