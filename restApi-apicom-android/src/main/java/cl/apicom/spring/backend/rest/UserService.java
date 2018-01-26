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
import cl.apicom.spring.backend.auxentities.RequestID;
import cl.apicom.spring.backend.entities.Detail;
import cl.apicom.spring.backend.entities.Lista;
import cl.apicom.spring.backend.entities.Price_Manuf_Sector;
import cl.apicom.spring.backend.entities.User;
import cl.apicom.spring.backend.repository.DetailRepository;
import cl.apicom.spring.backend.repository.Price_Manuf_SectorRepository;
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
	private DetailRepository detailrepository;
	
	@Autowired
	private Price_Manuf_SectorRepository price_manuf_sectorrepository;
	
	/*
	 * Plataforma: Administrador/Android
	 * Tipo: POST
	 * Descripcion: Login
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<User> getAllUser(){
		return userrepository.findAll();
	}
	
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
			return ResponseEntity.status(HttpStatus.OK).body(u);
		}
	}
	
	@RequestMapping(value = "/salary", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> getSalary(@RequestBody RequestID resource){
		
		if(userrepository.exists(resource.getId())){
			Iterable<Detail> details = detailrepository.getDetailUser(resource.getId());
			int count = 0;
			for(Detail d: details){count++;break;}
			if(count == 0){
				String jsonResponse = "{\"salary\":0}";
				return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
			}
			else{
				int salary = 0;
				for(Detail d: details){
					long id_sector = d.getId_sector();
					long id_manuf = d.getId_manufacture();
					Price_Manuf_Sector pms = price_manuf_sectorrepository.getPMSsectormanuf(id_sector, id_manuf);
					salary = salary + pms.getPrice();
				} 
				String jsonResponse = "{\"salary\":"+salary+"}";
				return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
			}
		}
		else{
			String jsonResponse = "{\"response\":400,\"desc\":\"Id de usuario no encontrado\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
	}
	
}
