package cl.apicom.spring.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.entities.Base;
import cl.apicom.spring.backend.repository.BaseRepository;

@CrossOrigin
@RestController
@RequestMapping("/base")
public class BaseService {
	
	@Autowired
	private BaseRepository baserepository;
}
