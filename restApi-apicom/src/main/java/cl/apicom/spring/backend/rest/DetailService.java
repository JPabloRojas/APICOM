package cl.apicom.spring.backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/date/{date}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getDetailDate(@PathVariable String date){
		try{
			Iterable_data_details idd = new Iterable_data_details();
			idd.setData(detailrepository.getDetailDate(date));
			return ResponseEntity.status(HttpStatus.OK).body(idd);
		}
		catch(Exception e){
			String jsonResponse = "{\"response\":400,\"desc\":\"No se ha podido obtener detalles de la fecha\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
	}
	
	/*
	 * Plataforma: Administrador
	 * Tipo: GET
	 * Descripcion: Obtiene todos los detalles correspondientes a un cliente
	 */
	@RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getDetailsFromClient(@PathVariable("id") long id){
		try{
			Iterable<Detail> details = detailrepository.getDetailFromClient(id);
			int count = 0;
			for(Detail d: details){count++;break;}
			if(count == 0){
				String jsonResponse = "{\"response\":400,\"desc\":\"Id de cliente no existe\"}";
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}
			else{
				return ResponseEntity.status(HttpStatus.OK).body(details);
			}
		}
		catch(Exception e){
			String jsonResponse = "{\"response\":400,\"desc\":\"No se ha podido obtener detalle OS\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
	}
	
	/*
	 * Plataforma: Administrador
	 * Tipo: GET
	 * Descripcion: Obtiene todos los detalles correspondientes a una OS.
	 */
	@RequestMapping(value = "ot/{id}", method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllOSforOT(@PathVariable("id") long id){
		try{
			Iterable<Detail> details = detailrepository.getDetailFromBase(id);
			int count = 0;
			for(Detail d: details){count++;break;}
			if(count == 0){
				String jsonResponse = "{\"response\":400,\"desc\":\"Id de OT no existe\"}";
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}
			else{
				return ResponseEntity.status(HttpStatus.OK).body(details);
			}
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
		}
	}
	
	/*
	 * Plataforma Administrador
	 * Tipo: GET
	 * Descripcion: Obtiene datos de una repectiva os
	 */
	@RequestMapping(value = "os/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getOS(@PathVariable("id") long id){
		try{
			Detail detail = detailrepository.findOne(id);
			if(detail == null){
				String jsonResponse = "{\"response\":400,\"desc\":\"Id de OS no existe\"}";
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}
			else{
				return ResponseEntity.status(HttpStatus.OK).body(detail);
			}
		}
		catch(Exception e){
			String jsonResponse = "{\"response\":400,\"desc\":\"No se ha podido obtener detalle OS\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
	}
	
	@RequestMapping(value = "os/nomina/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getOsNomina(@PathVariable("id") long id){
		Iterable<Detail> details = detailrepository.getDetailFromLista(id);
		int count = 0;
		for(Detail d: details){count++;break;}
		if(count == 0){
			String jsonResponse = "{\"response\":400,\"desc\":\"Id de nomina no existe\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			return ResponseEntity.status(HttpStatus.OK).body(details);
		}
	}
	
	
	
	
}
