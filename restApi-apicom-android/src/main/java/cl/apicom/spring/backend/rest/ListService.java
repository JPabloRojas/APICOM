package cl.apicom.spring.backend.rest;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.auxentities.ActiveInactiveModel;
import cl.apicom.spring.backend.auxentities.RequestID;
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
	

	/*
	 * Plataforma: Android
	 * Tipo: PUT
	 * Descripcion: Servicio que cambia el estado de actividad de una lista especifica(id)
	 * en la base de datos.
	 */
	@RequestMapping(value = "/inactive", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<?> inactiveList(@RequestBody ActiveInactiveModel resource){
		if(!listrepository.exists(resource.getId())){
			String jsonResponse = "{\"response\":400,\"desc\":\"Id lista no existe\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			Lista lista = listrepository.findOne(resource.getId());
			try{
				int active = lista.getActive();
				if(resource.getActive() == 0 && active == 1){
					lista.setActive(0);
					listrepository.save(lista);
					String jsonResponse = "{\"response\":200}";
					return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
				}
				else if(resource.getActive() == 1 && active  == 0){
					lista.setActive(1);
					listrepository.save(lista);
					String jsonResponse = "{\"response\":200}";
					return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
				}
				else{
					String jsonResponse = "resource.getActive() == "+resource.getActive()+"}";
					return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
				}
			}
			catch(Exception e){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			}
			
		}
	}
	
	
	
}
