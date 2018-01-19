package cl.apicom.spring.backend.rest;

import java.io.IOException;

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

import cl.apicom.spring.backend.entities.Gps_last;
import cl.apicom.spring.backend.repository.Gps_lastRepository;

@CrossOrigin
@RestController
@RequestMapping("/gps_last")
public class Gps_lastService {
	
	@Autowired
	private Gps_lastRepository gpslrepository;
	
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<?> updateGpsLast(@RequestBody Gps_last resource){
		Gps_last gl = null;
		gl = gpslrepository.findGpsUser(resource.getId_user());
		if(gl == null){
			try{
				gpslrepository.save(resource);
				String jsonResponse = "{\"response\":201}";
				return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse);
			}
			catch(DataIntegrityViolationException e){
				String jsonResponse = "{\"response\":400,\"message\":\"El id del usuario no existe\"}";
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}
		}
		else{
			gl.setLatitude(resource.getLatitude());
			gl.setLongitude(resource.getLongitude());
			gpslrepository.save(gl);
			String jsonResponse = "{\"response\":200}";
			return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
			
		}
	}
}
