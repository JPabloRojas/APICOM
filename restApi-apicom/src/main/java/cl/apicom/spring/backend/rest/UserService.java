package cl.apicom.spring.backend.rest;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
import cl.apicom.spring.backend.auxentities.UserCreationModel;
import cl.apicom.spring.backend.auxentities.UserUpdateModel;
import cl.apicom.spring.backend.entities.Lista;
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
			lrm.setId(u.getId());
			lrm.setUser_name(u.getUser_name());
			lrm.setMail(u.getMail());
			response.setStatus(200);
		}
		return lrm;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUser(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException{
		User u = userrepository.findOne(id);
		if(u == null){
			response.sendError(400, "Id de usuario no encontrado");
			return null;
		}
		else{
			response.setStatus(200);
			List<User> lu = new ArrayList<User>();
			lu.add(u);
			return lu;
		}
	}
	
	@RequestMapping(value = "/new/{user_name}/{user}/{password}/{mail}/{id_client}/{profile}/{payment_type}/{patente_vehiculo}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addUser(@PathVariable("user_name") String user_name,@PathVariable("user") String user_l, @PathVariable("password") String password, @PathVariable("mail") String mail, @PathVariable("id_client") int id_client, @PathVariable("profile") int profile, @PathVariable("payment_type") String payment_type, @PathVariable("patente_vehiculo") String patente_vehiculo) throws IOException{
		
		User u = userrepository.findbyUser(user_l);
		if(u != null){
			String jsonReturn = "{\"response\": 258, \"message\": \"El nombre de usuario no se encuentra disponible\"}";
			return ResponseEntity.status(258).body(jsonReturn);
		}
		else{
			User user = new User();
			user.setUser_name(user_name);
			user.setUser(user_l);
			user.setPassword(password);
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			user.setCreation_date(timestamp);
			user.setMail(mail);
			user.setActive(1);
			user.setId_client(id_client);
			user.setProfile(profile);
			user.setPayment_status(0);
			user.setPayment_type(payment_type);
			user.setPatente_vehiculo(patente_vehiculo);
			try{
				userrepository.save(user);
				String jsonReturn = "{\"response\": 201}";
				return ResponseEntity.status(HttpStatus.CREATED).body(jsonReturn);
			}
			catch(DataIntegrityViolationException e){
				String jsonReturn = "{\"response\": 259, \"message\": \"El id del cliente no existe\"}";
				return ResponseEntity.status(259).body(jsonReturn);
			}
		}
		
	}
	
	/*@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseBody
	public void updateUser(@RequestBody UserUpdateModel ucm, HttpServletResponse response){
		
		User
	}*/
	
	

	
}
