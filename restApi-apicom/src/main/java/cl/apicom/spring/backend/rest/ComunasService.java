package cl.apicom.spring.backend.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.auxentities.ComunasModel;
import cl.apicom.spring.backend.entities.Comunas;
import cl.apicom.spring.backend.repository.ComunaRepository;

@CrossOrigin
@RestController
@RequestMapping("/comuna")
public class ComunasService {
	
	@Autowired
	private ComunaRepository comunarepository;
	
	/*
	 * Plataforma: Administrador
	 * Tipo: GET
	 * Descripcion: Obtiene todas las comunas del sistema en formato id-nombre 
	 */
	
	@RequestMapping(value = "/idname", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllComunas(){
		try{
			Iterable<Comunas> comunas = comunarepository.findAll();
			List<ComunasModel> comunasList = new ArrayList<>();
			for(Comunas c: comunas){
				ComunasModel cAux = new ComunasModel();
				cAux.setId(c.getId());
				cAux.setNombre(c.getNombre());
				comunasList.add(cAux);
			}
			return ResponseEntity.status(HttpStatus.OK).body(comunasList);
		}
		catch(Exception e){
			String jsonResponse = "{\"response\":400,\"desc\":"+e.toString()+"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
	}
}
