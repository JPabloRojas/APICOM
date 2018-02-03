package cl.apicom.spring.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.entities.Ground;
import cl.apicom.spring.backend.repository.GroundRepository;

@CrossOrigin
@RestController
@RequestMapping("/ground")
public class GroundService {
	
	@Autowired
	private GroundRepository groundrepository;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Ground> getAllground(){
		return groundrepository.findAll();
	}
}
