package cl.apicom.spring.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.auxentities.Iterable_data_details;
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
	
	/*
	 * Plataforma: Administrador
	 * Tipo: GET
	 * Descripcion: Obtiene todos los detalles correspondientes a un dia
	 */
	@RequestMapping(value = "/day", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllDetailsDay(){
		try{
			Iterable_data_details idd = new Iterable_data_details();
			idd.setData(detailrepository.getDetailDay());
			return ResponseEntity.status(HttpStatus.OK).body(idd);
		}
		catch(Exception e){
			String jsonResponse = "{\"response\":400,\"desc\":\"No se ha podido obtener detalles del dia\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
	}
	
}
