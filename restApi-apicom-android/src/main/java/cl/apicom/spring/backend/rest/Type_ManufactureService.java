package cl.apicom.spring.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.entities.Type_Manufacture;
import cl.apicom.spring.backend.repository.Type_ManufactureRepository;

@CrossOrigin
@RestController
@RequestMapping("/tm")
public class Type_ManufactureService {
	
	@Autowired
	private Type_ManufactureRepository type_manufacturerepository;
}
