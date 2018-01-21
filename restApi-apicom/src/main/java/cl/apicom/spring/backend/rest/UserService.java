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
import cl.apicom.spring.backend.auxentities.Iterable_data_user;
import cl.apicom.spring.backend.entities.Lista;
import cl.apicom.spring.backend.entities.User;
import cl.apicom.spring.backend.repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserService {
	
	@Autowired
	private UserRepository userrepository;
	
	
	/*
	 * Plataforma: Administrador
	 * Tipo: GET
	 * Descripcion: Obtiene todos los usuarios del sistema
	 */
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllUsers(){
		Iterable_data_user ud = new Iterable_data_user();
		Iterable<User> users = userrepository.findAll();
		ud.setData(users);
		return ResponseEntity.status(HttpStatus.OK).body(ud);
	}
	
	/*
	 * Plataforma: Administrador/Android
	 * Tipo: POST
	 * Descripcion: Login
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public  ResponseEntity<?> loginUser(@RequestBody LoginModel resource){
		User u = null;
		LoginResponseModel lrm  = null;
		
		u = userrepository.findLogin(resource.getUser(), resource.getPassword());
		
		if(u == null){
			String jsonResponse = "{\"response\":400,\"message\":\"Usuario o contraseña incorrecto\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			lrm = new LoginResponseModel();
			lrm.setId(u.getId());
			lrm.setUser_name(u.getUser_name());
			lrm.setMail(u.getMail());
			return ResponseEntity.status(HttpStatus.OK).body(lrm);
		}
	}
	
	/*
	 * Plataforma: Administrador/Android
	 * Tipo: GET
	 * Descripcion: Obtiene los datos de un usuario
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getUser(@PathVariable("id") long id){
		User u = userrepository.findOne(id);
		if(u == null){
			//response.sendError(400, "Id de usuario no encontrado");
			//return null;
			String jsonResponse = "{\"response\":400,\"message\":\"Id de usuario no encontrado\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			//response.setStatus(200);
			List<User> lu = new ArrayList<User>();
			lu.add(u);
			return ResponseEntity.status(HttpStatus.OK).body(lu);
		}
	}
	
	/*
	 * Plataforma: Administrador
	 * Tipo: POST
	 * Descripcion: Registro de nuevo usuario, se inserta en la BD
	 */
	@RequestMapping(value = "/new/{user_name}/{user}/{password}/{mail}/{id_client}/{profile}/{payment_type}/{patente_vehiculo}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addUser(@PathVariable("user_name") String user_name,@PathVariable("user") String user_l, @PathVariable("password") String password, @PathVariable("mail") String mail, @PathVariable("id_client") long id_client, @PathVariable("profile") int profile, @PathVariable("payment_type") String payment_type, @PathVariable("patente_vehiculo") String patente_vehiculo){
		
		User u = userrepository.findbyUser(user_l);
		if(u != null){
			String jsonResponse = "{\"response\":258,\"message\":\"El nombre de usuario no se encuentra disponible\"}";
			return ResponseEntity.status(258).body(jsonResponse);
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
				String jsonResponse = "{\"response\":201}";
				return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse);
			}
			catch(DataIntegrityViolationException e){
				String jsonResponse = "{\"response\":400,\"message\":\"El id del cliente no existe\"}";
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}
		}
		
	}
	
	/*
	 * Plataforma: Administrador
	 * Tipo: PUT
	 * Descripcion: Actualiza los datos de un usuario
	 */
	@RequestMapping(value = "/update/{id}/{user_name}/{user}/{password}/{mail}/{id_client}/{profile}/{payment_type}/{patente_vehiculo}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @PathVariable("user_name") String user_name,@PathVariable("user") String user_l, @PathVariable("password") String password, @PathVariable("mail") String mail, @PathVariable("id_client") long id_client, @PathVariable("profile") int profile, @PathVariable("payment_type") String payment_type, @PathVariable("patente_vehiculo") String patente_vehiculo){
		User user = userrepository.findOne(id);
		if(user == null){
			String jsonResponse = "{\"response\":400,\"message\":\"Id usuario no existe\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			
			if(userrepository.findbyUser(user_l) != null){
				String jsonResponse = "{\"response\":400,\"message\":\"El nombre de usuario no se encuentra disponible\"}";
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}
			else{
				user.setUser_name(user_name);
				user.setUser(user_l);
				user.setPassword(password);
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				user.setLast_change_date(timestamp);
				user.setMail(mail);
				user.setId_client(id_client);
				user.setProfile(profile);
				user.setPayment_type(payment_type);
				user.setPatente_vehiculo(patente_vehiculo);
			try{
				userrepository.save(user);
				String jsonResponse = "{\"response\":200}";
				return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
			}
			catch(DataIntegrityViolationException e){
				String jsonResponse = "{\"response\":400,\"message\":\"El id del cliente no existe\"}";
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}
			}
		}
	}
	
	/*
	 * Plataforma: Administrador
	 * Tipo: PUT
	 * Descripcion: Activa/desactiva un usuario.
	 * 
	 */
	@RequestMapping(value = "/inactive/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> inactiveUser(@PathVariable("id") long id){
		User user = userrepository.findOne(id);
		if(user == null){
			String jsonResponse = "{\"response\":400,\"message\":\"Id usuario no existe\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			int active = user.getActive();
			if(active == 1){
				try{
					user.setActive(0);
					userrepository.save(user);
					String jsonResponse = "{\"response\":200}";
					return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
				}
				catch(DataIntegrityViolationException e){
					String jsonResponse = "{\"response\":400,\"message\":\"No se ha podido cambiar el estado\"}";
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
				}
			}
			else{
				try{
					user.setActive(1);
					userrepository.save(user);
					String jsonResponse = "{\"response\":200}";
					return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
				}
				catch(DataIntegrityViolationException e){
					String jsonResponse = "{\"response\":400,\"message\":\"No se ha podido cambiar el estado\"}";
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
				}
			}
		}
	}
	

	
}
