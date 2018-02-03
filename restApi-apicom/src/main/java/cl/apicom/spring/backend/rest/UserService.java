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
import cl.apicom.spring.backend.auxentities.DetailDayModel;
import cl.apicom.spring.backend.auxentities.Id_user_model;
import cl.apicom.spring.backend.auxentities.Iterable_data_user;
import cl.apicom.spring.backend.entities.Detail;
import cl.apicom.spring.backend.entities.Lista;
import cl.apicom.spring.backend.entities.Profile;
import cl.apicom.spring.backend.entities.User;
import cl.apicom.spring.backend.repository.ClientRepository;
import cl.apicom.spring.backend.repository.DetailRepository;
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
	
	@Autowired
	private ClientRepository clientrepository;
	
	@Autowired
	private DetailRepository detailrepository;
	
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public Iterable<User> getUsers(){
		return userrepository.findAll();
	}
	
	
	/*
	 * Plataforma: Administrador
	 * Tipo: GET
	 * Descripcion: Obtiene todos los usuarios del sistema
	 */
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllUsers(){
		try{
			Iterable_data_user ud = new Iterable_data_user();
			Iterable<User> users = userrepository.findAll();
			List<UserModel>  umList = new ArrayList<>();
			for(User u: users){
				UserModel umAux = new UserModel();
				Profile profile = profilerepository.findOne(u.getId_profile());
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
				umAux.setProfile_name(profile.getDescription());
				umAux.setId_profile(u.getId_profile());
				umAux.setPayment_status(u.getPayment_status());
				umAux.setPayment_type(u.getPayment_type());
				umAux.setPatente_vehiculo(u.getPatente_vehiculo());
				umList.add(umAux);
				
			}
		ud.setData(umList);
		return ResponseEntity.status(HttpStatus.OK).body(ud);
		}
		catch(Exception e){
			String jsonResponse = "{\"response\":400,\"desc\":"+e.toString()+"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
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
		if(!userrepository.exists(id)){
			String jsonResponse = "{\"response\":400,\"desc\":\"Id de usuario no encontrado\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			User u = userrepository.findOne(id);
			List<UserModel> lu = new ArrayList<UserModel>();
			Profile profile = profilerepository.findOne(u.getId_profile());
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
			umAux.setProfile_name(profile.getDescription());
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
	
	@RequestMapping(value = "/new/{user_name}/{user}/{password}/{mail}/{id_client}/{id_profile}/{payment_type}/{patente_vehiculo}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addUser(@PathVariable("user_name") String user_name,@PathVariable("user") String user_l, @PathVariable("password") String password, @PathVariable("mail") String mail, @PathVariable("id_client") String id_client, @PathVariable("id_profile") String id_profile, @PathVariable("payment_type") String payment_type, @PathVariable("patente_vehiculo") String patente_vehiculo){
		
		User u = userrepository.findbyUser(user_l);
		if(u != null){
			String jsonResponse = "{\"response\":258,\"desc\":\"El nombre de usuario no se encuentra disponible\"}";
			return ResponseEntity.status(258).body(jsonResponse);
		}
		else if(!profilerepository.exists(Long.parseLong(id_profile))){
			String jsonResponse = "{\"response\":258,\"desc\":\"El perfil no se encuentra disponible\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else if(!clientrepository.exists(Long.parseLong(id_client))){
			String jsonResponse = "{\"response\":400,\"desc\":\"El id del cliente no existe\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
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
			user.setId_client(Long.parseLong(id_client));
			user.setId_profile(Long.parseLong(id_profile));
			user.setPayment_status(0);
			user.setPayment_type(payment_type);
			user.setPatente_vehiculo(patente_vehiculo);
			try{
				userrepository.save(user);
				String jsonResponse = "{\"response\":201}";
				return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse);
			}
			catch(Exception e){
				String jsonResponse = "{\"response\":400,\"desc\":"+e.toString()+"}";
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}	
		}			
	}
	
	/*
	 * Plataforma: Administrador
	 * Tipo: PUT
	 * Descripcion: Actualiza los datos de un usuario
	 */
	@RequestMapping(value = "/update/{id}/{user_name}/{user}/{password}/{mail}/{id_client}/{id_profile}/{payment_type}/{patente_vehiculo}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @PathVariable("user_name") String user_name,@PathVariable("user") String user_l, @PathVariable("password") String password, @PathVariable("mail") String mail, @PathVariable("id_client") String id_client, @PathVariable("id_profile") String id_profile, @PathVariable("payment_type") String payment_type, @PathVariable("patente_vehiculo") String patente_vehiculo){
		if(!userrepository.exists(id)){
			String jsonResponse = "{\"response\":400,\"desc\":\"Id usuario no existe\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else if(!user_l.equals(userrepository.findOne(id).getUser()) && userrepository.findbyUser(user_l) != null){
			String jsonResponse = "{\"response\":400,\"desc\":\"El nombre de usuario no se encuentra disponible\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		
		else if(!profilerepository.exists(Long.parseLong(id_profile))){
			String jsonResponse = "{\"response\":258,\"desc\":\"El perfil no se encuentra disponible\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else if(!clientrepository.exists(Long.parseLong(id_client))){
			String jsonResponse = "{\"response\":400,\"desc\":\"El id del cliente no existe\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			User user = userrepository.findOne(id);
			user.setUser_name(user_name);
			user.setUser(user_l);
			user.setPassword(password);
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			user.setLast_change_date(timestamp);
			user.setMail(mail);
			user.setId_client(Long.parseLong(id_client));
			user.setId_profile(Long.parseLong(id_profile));
			user.setPayment_type(payment_type);
			user.setPatente_vehiculo(patente_vehiculo);
			try{
				userrepository.save(user);
				String jsonResponse = "{\"response\":201}";
				return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse);
			}
			catch(Exception e){
				String jsonResponse = "{\"response\":400,\"desc\":"+e.toString()+"}";
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
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
		if(!userrepository.exists(id)){
			String jsonResponse = "{\"response\":400,\"desc\":\"Id usuario no existe\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			User user = userrepository.findOne(id);
			int active = user.getActive();
			if(active == 1){
				try{
					user.setActive(0);
					userrepository.save(user);
					String jsonResponse = "{\"response\":201}";
					return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse);
				}
				catch(Exception e){
					String jsonResponse = "{\"response\":400,\"desc\":\"No se ha podido cambiar el estado\"}";
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
				}
			}
			else{
				try{
					user.setActive(1);
					userrepository.save(user);
					String jsonResponse = "{\"response\":201}";
					return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse);
				}
				catch(Exception e){
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
		
		if(!userrepository.exists(id)){
			String jsonResponse = "{\"response\":400,\"name\":\"Id usuario no existe\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			User user = userrepository.findOne(id);
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
		try{
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
		catch(Exception e){
			String jsonResponse = "{\"response\":400,\"desc\":"+e.toString()+"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
	}
	
	
	/*
	 * Plataforma: Administrador
	 * Tipo: GET
	 * Descripcion: Obtiene los perfiles de usuario con un indicador si el usuario pertenece a este perfil.
	 */
	@RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getProfile(@PathVariable("id") long id){
		
		if(!userrepository.exists(id)){
			String jsonResponse = "{\"response\":400,\"desc\":\"Id usuario no existe\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			User user = userrepository.findOne(id);
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
	
	/*
	 * Plataforma: Administrador
	 * Tipo: GET
	 * Descripcion: Obtiene valores asociados a la plantilla de seguimiento de distribuidores en terreno,
	 */
	@RequestMapping(value = "day/format", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllDetailsDayFormat(){
		
		Iterable<User> users = userrepository.getUserActive();
		//List<DetailDayModel> ddm_list = new ArrayList<>();
		String ddm_return = "[";
		for(User u: users){
			DetailDayModel ddmAux = new DetailDayModel();
			Iterable<Detail> details = detailrepository.getDetailUser((u.getId()));
			int cartas_totales = 0;
			int cartas_entregadas = 0;
			int paquetes_totales = 0;
			int paquetes_entregados = 0;
			for(Detail d: details){
				if(d.getManufacture().getName().equals("carta")){
					cartas_totales++;
					if(d.getEstate() == 1){
						cartas_entregadas++;
					}
				}
				else{
					paquetes_totales++;
					if(d.getEstate() == 1){
						paquetes_entregados++;
					}
				}
			}
			String id = "{id: \'"+u.getId()+"\',";
			String nombre = "nombre: \'"+u.getUser_name()+"\',";
			double latitude = u.getLast_gps_user().getLatitude();
			double longitude = u.getLast_gps_user().getLongitude();
			String position = "position: new google.maps.LatLng("+latitude+","+" "+longitude+"),";
			String tipo = "tipo: \'"+u.getProfile().getDescription()+"\',";
			String cartas_totales_s = "cartas_totales: \'"+cartas_totales+"\',";
			String cartas_entregadas_s = "cartas_entregadas: \'"+cartas_entregadas+"\',";
			String paquetes_totales_s =  "paquetes_totales: \'"+paquetes_totales+"\'";
			String paquetes_entregados_s = "paquetes_entregados: \'"+paquetes_entregados+"\',";
			String desc_tipo = "desctipo: \'"+u.getGround().getMobility()+"\',";
			String estado = "estado: \'"+u.getGround().getEstate()+"\'},";
			
			id += nombre+position+tipo+cartas_totales_s+cartas_entregadas_s+paquetes_totales_s+paquetes_entregados_s+desc_tipo+estado;
			ddm_return += id;
		}
		
		String ddm_return_Aux = ddm_return.substring(0, ddm_return.length()-1)+"]";
		return ResponseEntity.status(HttpStatus.OK).body(ddm_return_Aux);
	}
	
	
	
	
	
}
