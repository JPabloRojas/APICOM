package cl.apicom.spring.backend.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.auxentities.RequestSingleData;
import cl.apicom.spring.backend.entities.Gps;
import cl.apicom.spring.backend.entities.User;
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
	
	//A borrar
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseBody
	public void updateGps(@RequestBody RequestSingleData resource, HttpServletResponse response) throws IOException{
		Gps gps = null;
		gps = gpsrepository.findGpsUser(Integer.parseInt(resource.getData()));
		if(gps == null){
			response.sendError(400, "gps no encontrado para el usuario indicado");
		}
		else{
			gps.setLatitude(666);
			gps.setLongitude(666);
			gpsrepository.save(gps);
			response.setStatus(200);
		}
	}
	
}
