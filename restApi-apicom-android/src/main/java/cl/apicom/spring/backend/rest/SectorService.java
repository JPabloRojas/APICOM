package cl.apicom.spring.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.entities.Sector;
import cl.apicom.spring.backend.repository.SectorRepository;

@CrossOrigin
@RestController
@RequestMapping("/sector")
public class SectorService {
	
	@Autowired
	private SectorRepository sectorrepository;
}
