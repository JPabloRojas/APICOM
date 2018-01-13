package cl.apicom.spring.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.entities.Gps;
import cl.apicom.spring.backend.repository.GpsRepository;;

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
	
}
