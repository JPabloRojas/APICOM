package cl.apicom.spring.backend.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import cl.apicom.spring.backend.entities.User;
import cl.apicom.spring.backend.repository.BaseRepository;
import cl.apicom.spring.backend.repository.ClientRepository;
import cl.apicom.spring.backend.repository.DetailRepository;
import cl.apicom.spring.backend.repository.ListRepository;
import cl.apicom.spring.backend.repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/detail")
public class DetailService {
	
	@Autowired
	private DetailRepository detailrepository;
	
	@Autowired
	private ClientRepository clientrepository;
	
	@Autowired
	private ListRepository listrepository;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Detail> getAllDetails(){
		return detailrepository.findAll();
	}
	
	/*
	 * Plataforma: Administrador
	 * Tipo: GET
	 * Descripcion: Obtiene todos los detalles correspondientes al dia
	 */
	@RequestMapping(value = "/day/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllDetailsDay(@PathVariable long id){
		try{
			Iterable_data_details idd = new Iterable_data_details();
			idd.setData(detailrepository.getDetailDay(id));
			return ResponseEntity.status(HttpStatus.OK).body(idd);
		}
		catch(Exception e){
			String jsonResponse = "{\"response\":400,\"desc\":\"No se ha podido obtener detalles del dia\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
	}
		
	
	/*
	 * Plataforma: Administrador
	 * Tipo:GET
	 * Descripcion: Obtiene todos los detalles correspsondientes a una fecha en especifico
	 */
	@RequestMapping(value = "/date/{date}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getDetailDate(@PathVariable String date){
		try{
			Iterable_data_details idd = new Iterable_data_details();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date_d = formatter.parse(date);
			idd.setData(detailrepository.getDetailDate(date_d));
			return ResponseEntity.status(HttpStatus.OK).body(idd);
		}
		catch(Exception e){
			String jsonResponse = "{\"response\":400,\"desc\":"+e.toString()+"}";
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
			if(!clientrepository.exists(id)){
				String jsonResponse = "{\"response\":400,\"desc\":\"Id de cliente no existe\"}";
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}
			else{
				Iterable<Detail> details = detailrepository.getDetailFromClient(id);
				return ResponseEntity.status(HttpStatus.OK).body(details);
			}
		}
		catch(Exception e){
			String jsonResponse = "{\"response\":400,\"desc\":\"No se ha podido obtener detalle OS\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
	}
	
	/*
	 * Plataforma:Administrador
	 * Tipo: GET
	 * Descripcion: Ontiene todos los detalles de un cliente entre fechas especificadas
	 */
	@RequestMapping(value = "/client/date/{id}/{date_init}/{date_end}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getDetailFromClientDate(@PathVariable("id") long id, @PathVariable("date_init") String date_init, @PathVariable String date_end){
		try{
			if(!clientrepository.exists(id)){
				String jsonResponse = "{\"response\":400,\"desc\":\"Id de cliente no existe\"}";
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}
			else{
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date date_i = formatter.parse(date_init);
				Date date_e = formatter.parse(date_end);
				Iterable<Detail> details = detailrepository.getDetailFromClientDate(date_i, date_e, id);
				return ResponseEntity.status(HttpStatus.OK).body(details);
			}
		}
		catch(Exception e){
			String jsonResponse = "{\"response\":400,\"desc\":"+e.toString()+"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
	}
	
	/*
	 * Plataforma: Administrador
	 * Tipo: GET
	 * Descripcion: Obtiene todos los detalles correspondientes a una OS.
	 */
	@RequestMapping(value = "/ot/{id}", method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllOSforOT(@PathVariable("id") long id){
		try{
			if(!detailrepository.exists(id)){
				String jsonResponse = "{\"response\":400,\"desc\":\"Id de OT no existe\"}";
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}
			else{
				Iterable<Detail> details = detailrepository.getDetailFromBase(id);
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
	@RequestMapping(value = "/os/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getOS(@PathVariable("id") long id){
		try{
			if(!detailrepository.exists(id)){
				String jsonResponse = "{\"response\":400,\"desc\":\"Id de OS no existe\"}";
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}
			else{
				Detail detail = detailrepository.findOne(id);
				return ResponseEntity.status(HttpStatus.OK).body(detail);
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
	 * Descripcion: Obtiene los detalles de una lista
	 */
	@RequestMapping(value = "/os/nomina/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getOsNomina(@PathVariable("id") long id){
		if(!listrepository.exists(id)){
			String jsonResponse = "{\"response\":400,\"desc\":\"Id de nomina no existe\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		else{
			List<Detail> details = listrepository.findOne(id).getDetail_list();
			return ResponseEntity.status(HttpStatus.OK).body(details);
		}
	}
	
	
	
	
}
