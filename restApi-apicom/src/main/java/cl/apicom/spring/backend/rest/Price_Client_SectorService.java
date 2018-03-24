package cl.apicom.spring.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.entities.Price_Client_Sector;
import cl.apicom.spring.backend.repository.Price_Client_SectorRepository;

@CrossOrigin
@RestController
@RequestMapping("/pcs")
public class Price_Client_SectorService {
	
	@Autowired
	private Price_Client_SectorRepository price_client_sectorrepository;
	
	/*
	 * Plataforma: Administrador
	 * Tipo: GET
	 * Descripcion: Servicio que permite obtener todos los precios por cliente según sector del sistema.
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Price_Client_Sector> getAllpcs(){
		return price_client_sectorrepository.findAll();
	}
}
