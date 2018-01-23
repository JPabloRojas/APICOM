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
import cl.apicom.spring.backend.auxentities.UserModel;
import cl.apicom.spring.backend.auxentities.UserProfileModel;
import cl.apicom.spring.backend.auxentities.UserUpdateModel;
import cl.apicom.spring.backend.auxentities.Id_user_model;
import cl.apicom.spring.backend.auxentities.Iterable_data_user;
import cl.apicom.spring.backend.entities.Lista;
import cl.apicom.spring.backend.entities.Profile;
import cl.apicom.spring.backend.entities.User;
import cl.apicom.spring.backend.repository.ProfileRepository;
import cl.apicom.spring.backend.repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserService {
	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private ProfileRepository profilerepository;
	
	
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
		List<UserModel>  umList = new ArrayList<>();
		for(User u: users){
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
			umList.add(umAux);
			
		}
		ud.setData(umList);
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
			String jsonResponse = "{\"response\":400,\"desc\":\"Usuario o contraseña incorrecto\"}";
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
			String jsonResponse = "{\"response\":400,\"desc\":\"Id de usuario no encontrado\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			//response.setStatus(200);
			List<UserModel> lu = new ArrayList<UserModel>();
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
			String jsonResponse = "{\"response\":258,\"desc\":\"El nombre de usuario no se encuentra disponible\"}";
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
			user.setId_profile(profile);
			user.setPayment_status(0);
			user.setPayment_type(payment_type);
			user.setPatente_vehiculo(patente_vehiculo);
			try{
				userrepository.save(user);
				String jsonResponse = "{\"response\":201}";
				return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse);
			}
			catch(DataIntegrityViolationException e){
				String jsonResponse = "{\"response\":400,\"desc\":\"El id del cliente no existe\"}";
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
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @PathVariable("user_name") String user_name,@PathVariable("user") String user_l, @PathVariable("password") String password, @PathVariable("mail") String mail, @PathVariable("id_client") long id_client, @PathVariable("profile") long profile, @PathVariable("payment_type") String payment_type, @PathVariable("patente_vehiculo") String patente_vehiculo){
		User user = userrepository.findOne(id);
		if(user == null){
			String jsonResponse = "{\"response\":400,\"desc\":\"Id usuario no existe\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			String guser = user.getUser();
			if(!user_l.equals(guser) && userrepository.findbyUser(user_l) != null){
				String jsonResponse = "{\"response\":400,\"desc\":\"El nombre de usuario no se encuentra disponible\"}";
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}
			else{
				if(profilerepository.findOne(profile) == null){
					String jsonResponse = "{\"response\":400,\"desc\":\"No existe el perfil\"}";
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
					user.setId_profile(profile);
					user.setPayment_type(payment_type);
					user.setPatente_vehiculo(patente_vehiculo);
					try{
						userrepository.save(user);
						String jsonResponse = "{\"response\":200}";
						return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
					}
					catch(DataIntegrityViolationException e){
						String jsonResponse = "{\"response\":400,\"desc\":\"No se ha podido actualizar\"}";
						return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
					}
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
	@ResponseBody
	public ResponseEntity<?> inactiveUser(@PathVariable("id") long id){
		User user = userrepository.findOne(id);
		if(user == null){
			String jsonResponse = "{\"response\":400,\"desc\":\"Id usuario no existe\"}";
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
					String jsonResponse = "{\"response\":400,\"desc\":\"No se ha podido cambiar el estado\"}";
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
					String jsonResponse = "{\"response\":400,\"desc\":\"No se ha podido cambiar el estado\"}";
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
				}
			}
		}
	}
	
	/*
	 * Plataforma: Administrador
	 * Tipo: GET
	 * Descripcion: Obtiene el nombre de un distribuidor
	 */
	
	@RequestMapping(value = "/name/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getUserName(@PathVariable("id") long id){
		User user = userrepository.findOne(id);
		if(user == null){
			String jsonResponse = "{\"response\":400,\"desc\":\"Id usuario no existe\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			String name = user.getUser_name();
			String jsonResponse = "{\"response\":200,\"desc\":"+name+"}";
			return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
		}
	}
	
	/*
	 * Plataforma: Administrador
	 * Tipo: GET
	 * Descripcion: Obtiene usuarios en formato id-nombre
	 */
	@RequestMapping(value = "/IdName", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getIdName(){
		Iterable<User> users = userrepository.findAll();
		List<Id_user_model> ium_list = new ArrayList<>();
		for(User u: users){
			Id_user_model ium = new Id_user_model();
			ium.setId(u.getId());
			ium.setNombre(u.getUser_name());
			ium_list.add(ium);
		}
		return ResponseEntity.status(HttpStatus.OK).body(ium_list);
	}
	
	@RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getProfile(@PathVariable("id") long id){
		User user = userrepository.findOne(id);
		if(user == null){
			String jsonResponse = "{\"response\":400,\"desc\":\"Id usuario no existe\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			Iterable<Profile> profiles = profilerepository.findAll();
			List<UserProfileModel> upm_list = new ArrayList<>(); 
			for(Profile u: profiles){
				UserProfileModel upm = new UserProfileModel();
				upm.setId(u.getId());
				upm.setName(u.getDescription());
				if(user.getId_profile() == u.getId()){
					upm.setActive(1);
				}
				else{
					upm.setActive(0);
				}
				upm_list.add(upm);
			}
			return ResponseEntity.status(HttpStatus.OK).body(upm_list);
		}
	}
	
}
