package cl.apicom.spring.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.entities.Detail;
import cl.apicom.spring.backend.repository.DetailRepository;

@CrossOrigin
@RestController
@RequestMapping("/detail")
public class DetailService {
	
	@Autowired
	private DetailRepository detailrepository;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Detail> getAllDetails(){
		return detailrepository.findAll();
	}	
}
