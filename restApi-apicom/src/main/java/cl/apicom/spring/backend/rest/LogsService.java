package cl.apicom.spring.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.entities.Logs;
import cl.apicom.spring.backend.repository.LogsRepository;

@CrossOrigin
@RestController
@RequestMapping("/logs")
public class LogsService {
	
	@Autowired LogsRepository logsrepository;
	
	/*
	 * Plataforma: Administrador
	 * Tipo: GET
	 * Descripcion: Servicio que permite obtener todos los logs del sistema.
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Logs> getAllLogs(){
		return logsrepository.findAll();		
	}
}
