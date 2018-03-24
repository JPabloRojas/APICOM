package cl.apicom.spring.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.entities.Price_Manuf_Sector;
import cl.apicom.spring.backend.repository.Price_Manuf_SectorRepository;

@CrossOrigin
@RestController
@RequestMapping("/pms")
public class Price_Manuf_SectorService {
	
	@Autowired
	private Price_Manuf_SectorRepository price_manuf_sectorrepository;
	
	
	/*
	 * Plataforma: Administrador
	 * Tipo: GET
	 * Descripcion: Servicio que permite obtener todos los precios según producto del sistema.
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Price_Manuf_Sector> getAllpms(){
		return price_manuf_sectorrepository.findAll();
	}
}
