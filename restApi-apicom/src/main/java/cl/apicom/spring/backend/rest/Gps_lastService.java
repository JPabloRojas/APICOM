package cl.apicom.spring.backend.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
	public void updateGpsLast(@RequestBody Gps_last resource, HttpServletResponse response) throws IOException{
		Gps_last gl = null;
		gl = gpslrepository.findGpsUser(resource.getId_user());
		if(gl == null){
			try{
				gpslrepository.save(resource);
				response.setStatus(201);
			}
			catch(DataIntegrityViolationException e){
				response.sendError(400, "El id del usuario no existe");
			}
		}
		else{
			gl.setLatitude(resource.getLatitude());
			gl.setLongitude(resource.getLongitude());
			gpslrepository.save(gl);
			response.setStatus(200);
			
		}
	}
}
