package cl.apicom.spring.backend.rest;

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
import cl.apicom.spring.backend.entities.Price_Manuf_Sector;
import cl.apicom.spring.backend.repository.Price_Manuf_SectorRepository;

@CrossOrigin
@RestController
@RequestMapping("/pms")
public class Price_Manuf_SectorService {
	
	@Autowired
	private Price_Manuf_SectorRepository price_manuf_sectorrepository;
	
}
