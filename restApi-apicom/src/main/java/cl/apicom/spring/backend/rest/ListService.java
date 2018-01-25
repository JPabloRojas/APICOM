package cl.apicom.spring.backend.rest;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.auxentities.RequestSingleData;
import cl.apicom.spring.backend.entities.Lista;
import cl.apicom.spring.backend.entities.User;
import cl.apicom.spring.backend.repository.ListRepository;
import cl.apicom.spring.backend.repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/list")
public class ListService {
	
	@Autowired
	private ListRepository listrepository;
	
	@Autowired
	private UserRepository userrepository;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Lista> getAllLists(){
		return listrepository.findAll();
	}
	
}
