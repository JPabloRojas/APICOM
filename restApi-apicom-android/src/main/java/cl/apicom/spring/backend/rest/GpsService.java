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


import cl.apicom.spring.backend.entities.Gps;
import cl.apicom.spring.backend.entities.User;
import cl.apicom.spring.backend.repository.GpsRepository;;
//Solo se usara si se impleneta el historial de gps
@CrossOrigin
@RestController
@RequestMapping("/gps")
public class GpsService {
	
	@Autowired
	private GpsRepository gpsrepository;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Gps> getAllGps(){
		return gpsrepository.findAll();
	}
	
	
	
	/*@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public void updateGps(@RequestBody Gps resource, HttpServletResponse response) throws IOException{
		try{
			gpsrepository.save(resource);
			response.setStatus(201);
		}
		catch(DataIntegrityViolationException e){
			response.sendError(400, "Id usuario no valida");
		}
	}*/
	
}
