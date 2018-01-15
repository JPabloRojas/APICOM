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

import cl.apicom.spring.backend.auxentities.RequestUserModel;
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
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public void addList(@RequestBody RequestUserModel resource, HttpServletResponse response) throws IOException{
		User u = userrepository.findbyUser(resource.getUser());
		if(u == null){
			response.sendError(400);
		}
		else{
			Lista list = new Lista();
			list.setId_user(u.getId());
			 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			list.setList_date(timestamp);
			list.setPrice(0);
			try{
				listrepository.save(list);
				response.setStatus(201);
			}
			catch(DataIntegrityViolationException e){
				response.sendError(400);
			}
		}
	}
}
