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
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Manufacture> getAllManu(){
		return manufacturerepository.findAll();
	}
	
	@RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Manufacture> getAllManufUser(@PathVariable("id") long id){
		return manufacturerepository.getAllManufUser(id);
	}
}
