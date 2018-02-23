package cl.apicom.spring.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Base> getAllBases(){
		return baserepository.findAll();
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getOT(@PathVariable long id){
		if(!baserepository.exists(id)){
			String jsonResponse = "{\"response\":400,\"desc\":\"Id de OT no encontrado\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			try{
				Base base = baserepository.findOne(id);
				return ResponseEntity.status(HttpStatus.OK).body(base);
			}
			catch(Exception e){
				String jsonResponse = "{\"response\":400"+e.toString()+"}";
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}
		}
	}
}
