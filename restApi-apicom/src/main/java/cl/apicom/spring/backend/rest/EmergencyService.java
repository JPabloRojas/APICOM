package cl.apicom.spring.backend.rest;

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

import cl.apicom.spring.backend.entities.Emergency;
import cl.apicom.spring.backend.repository.EmergencyRepository;

@CrossOrigin
@RestController
@RequestMapping("/emergency")
public class EmergencyService {
	
	@Autowired 
	private EmergencyRepository emergencyrepository;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Emergency> getAllEmergencys(){
		return emergencyrepository.findAll();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addEmergency(@RequestBody Emergency resource){
		
		try{
			emergencyrepository.save(resource);
			String jsonResponse = "{\"response\": 201}";
			return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse);
		}
		catch(DataIntegrityViolationException e){
			String jsonResponse = "{\"response\": 400}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		
	}
	
}
