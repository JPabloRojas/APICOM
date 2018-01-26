package cl.apicom.spring.backend.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.auxentities.EmergencyModel;
import cl.apicom.spring.backend.entities.Emergency;
import cl.apicom.spring.backend.entities.User;
import cl.apicom.spring.backend.repository.EmergencyRepository;
import cl.apicom.spring.backend.repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/emergency")
public class EmergencyService {
	
	@Autowired 
	private EmergencyRepository emergencyrepository;
	
	@Autowired
	private UserRepository userrepository;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Emergency> getAllEmergencys(){
		return emergencyrepository.findAll();
	}
	
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addEmergency(@RequestBody EmergencyModel resource){
		try{
			Emergency emergency = new Emergency();
			emergency.setId_user(resource.getId_user());
			emergency.setType(resource.getType());
			emergency.setDescription(resource.getDescription());
			emergency.setDate(resource.getDate());
			emergencyrepository.save(emergency);
			
			
			
			String phone = resource.getPhone();
			Iterable<Long> ids_details = resource.getIds_detalles();
			List<Long> id_repeated = new ArrayList<>();
			for(Long id: ids_details){
				User u = userrepository.finUserDetail(id);
				if(!id_repeated.contains(u.getId()))
				{
					String number = u.getMail();
					id_repeated.add(u.getId());
					//Codigo mensaje texto y correo
				}		
			}
			String jsonResponse = "{\"response\":400}";
			return ResponseEntity.status(HttpStatus.OK).body(id_repeated);
			
		}
		catch(Exception e){
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
		}
		
	}
	
}
