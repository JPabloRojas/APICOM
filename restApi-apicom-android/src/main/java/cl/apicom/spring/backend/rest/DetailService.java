package cl.apicom.spring.backend.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.auxentities.RequestID;
import cl.apicom.spring.backend.auxentities.UpdateDetailModel;
import cl.apicom.spring.backend.entities.Detail;
import cl.apicom.spring.backend.entities.User;
import cl.apicom.spring.backend.repository.DetailRepository;
import cl.apicom.spring.backend.repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/detail")
public class DetailService {
	
	@Autowired
	private DetailRepository detailrepository;
	
	@Autowired
	private UserRepository userrepository;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Detail> getAllDetails(){
		return detailrepository.findAll();
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> getDetailUser(@RequestBody RequestID resource){
		User user = userrepository.findOne(resource.getId());
		if(user == null){
			String jsonResponse = "{\"response\":400,\"desc\":\"Id usuario no existe\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			try{
				Iterable<Detail> details = detailrepository.getDetailUser(resource.getId());
				List<String> direcciones = new ArrayList<>();
				for(Detail d: details){
					if(d.getId_repeat() == 0){
						String dir = d.getAdress();
						if(direcciones.contains(dir)){
							int count = 1;
							for(String dAux: direcciones){
								if(dAux.equals(dir)){
									d.setId_repeat(count);
								}
								else{
									count++;
								}
							}
						}
						else{
							direcciones.add(dir);
							int length = direcciones.size();
							d.setId_repeat(length);
						}
						detailrepository.save(d);
					}
					else{
						break;
					}
				}			
				return ResponseEntity.status(HttpStatus.OK).body(details);
			}
			catch(Exception e){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
			}
		}
		
	}
	
	@RequestMapping(value = "/update/state", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<?> updateState(@RequestBody UpdateDetailModel resource){
		
		Detail detail = detailrepository.findOne(resource.getId());
		if(detail == null){
			String jsonResponse = "{\"response\":400,\"desc\":\"Id detalle no existe\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			detail.setEstate(resource.getState());
			detail.setComment(resource.getComment());
			try{
				detailrepository.save(detail);
				String jsonResponse = "{\"response\":400}";
				return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
			}
			catch(Exception e){
				String jsonResponse = "{\"response\":400,\"desc\":"+e.toString()+"}";
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}
		}
	}
}
