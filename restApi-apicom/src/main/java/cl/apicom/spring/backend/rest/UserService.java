package cl.apicom.spring.backend.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.ConstraintViolationException;
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

import com.mysql.fabric.Response;

import cl.apicom.spring.backend.auxentities.LoginModel;
import cl.apicom.spring.backend.auxentities.LoginResponseModel;
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
	
	//Servicio rest de Login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public  LoginResponseModel loginUser(@RequestBody LoginModel resource, HttpServletResponse response) throws IOException{
		User u = null;
		LoginResponseModel lrm  = null;
		
		u = userrepository.findLogin(resource.getUser(), resource.getPassword());
		if(u == null){
			response.sendError(400, "Usuario o contraseña incorrecto");
		}
		else{
			lrm = new LoginResponseModel();
			lrm.setUser_name(u.getUser_name());
			lrm.setMail(u.getMail());
			response.setStatus(200);
		}
		return lrm;
	}
	
	
	//Servicio rest de creacion de usuario
	@RequestMapping(method = RequestMethod.POST)
	//@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void addUser(@RequestBody User resource ,HttpServletResponse response) throws IOException{
		User u = userrepository.findbyUser(resource.getUser());
		if(u != null){
			response.sendError(460, "Usuario no disponible");
		}
		else{
			userrepository.save(resource);
			response.setStatus(201);
		}
	}
	

	/*@RequestMapping(value = "test/{num}", method = RequestMethod.GET)
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
		
	}*/
}
