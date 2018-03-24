package cl.apicom.spring.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.entities.Manufacture;
import cl.apicom.spring.backend.repository.ManufactureRepository;

@CrossOrigin
@RestController
@RequestMapping("/manufacture")
public class ManufactureService {
	
	@Autowired
	private ManufactureRepository manufacturerepository;
	
	
}
