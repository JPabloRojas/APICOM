package cl.apicom.spring.backend.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.entities.Gps_last;
import cl.apicom.spring.backend.repository.Gps_lastRepository;

@CrossOrigin
@RestController
@RequestMapping("/gps_last")
public class Gps_lastService {
	
	@Autowired
	private Gps_lastRepository gpslrepository;
}
