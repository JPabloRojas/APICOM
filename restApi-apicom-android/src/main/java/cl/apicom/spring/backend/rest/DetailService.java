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
import cl.apicom.spring.backend.entities.Lista;
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
	
	@RequestMapping(value = "/all",method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Detail> getAllDetails(){
		return detailrepository.findAll();
	}
	
	/*
	 * Plataforma: Android
	 * Tipo: POST
	 * Descripcion: Obtiene todos los detalles de un usuario con ID especifico, si es la primera vez
	 * que se ejecuta el metodo, se asignan los valores correspondientes idrepeat a la base de datos
	 * que corresponden a los detalles que van hacia una misma direccion.
	 * 
	 */
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
				List<double[]> direcciones = new ArrayList<>();
				for(Detail d: details){
					int count = 0;
					if(d.getId_repeat() == 0){
						for(double[] coord: direcciones){
							if(d.getLatitude() == coord[0] && d.getLongitude() == coord[1]){
								d.setId_repeat(count+1);
							}
							else{
								count++;
							}
						}
						if(count == direcciones.size()){
							double[] coordenadas = new double[2];
							coordenadas[0] = d.getLatitude();
							coordenadas[1] = d.getLongitude();
							direcciones.add(coordenadas);
							d.setId_repeat(count+1);
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
	
	
	/*
	 * Plataforma: Android
	 * Tipo: PUT
	 * Descripcion: Servicio que permite actualizar el estado de un detalle segun el mapeo de base de datos
	 * entregado en la documentación.
	 */
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
			detail.setReceptor(resource.getReceptor());
			try{
				detailrepository.save(detail);
				String jsonResponse = "{\"response\":200}";
				return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
			}
			catch(Exception e){
				String jsonResponse = "{\"response\":400,\"desc\":"+e.toString()+"}";
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
			}
		}
	}
}
