package cl.apicom.spring.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.entities.Profile;
import cl.apicom.spring.backend.repository.ProfileRepository;

@CrossOrigin
@RestController
@RequestMapping("/profile")
public class ProfileService {
	
	@Autowired
	private ProfileRepository profilerepository;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Profile> getAllProfiles(){
		return profilerepository.findAll();
	}
}
