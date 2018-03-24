package cl.apicom.spring.backend.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.auxentities.ReadGeo;
import cl.apicom.spring.backend.entities.Gps_last;
import cl.apicom.spring.backend.repository.Gps_lastRepository;

@CrossOrigin
@RestController
@RequestMapping("/gps_last")
public class Gps_lastService {
	
	@Autowired
	private Gps_lastRepository gpslrepository;
	
	/*
	 * Plataforma: Administrador
	 * Tipo: GET
	 * Descripcion: Servicio que a partir de una direccion y devuelve las coordenadas usando
	 * API de google maps.
	 */
	
	@RequestMapping(value = "/adress/{direccion}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> test(@PathVariable("direccion") String direccion) throws IOException, JSONException{
		String direccion_b = direccion.replace(' ', '+').replace(',', '+');
		try{
			String url = "https://maps.googleapis.com/maps/api/geocode/json?address="+direccion_b+"&key=AIzaSyBjvBbow6Vp-GHXhgGZhZZregtDptD_omA";
			ReadGeo rg = new ReadGeo();
			JSONObject json = rg.readJsonFromUrl(url);
			JSONArray jArray = json.getJSONArray("results");
			JSONObject infoBody = jArray.getJSONObject(0).getJSONObject("geometry").getJSONObject("location");
			String jsonReturn = "{\"latitude\":"+infoBody.getDouble("lat")+",\"longitude\":"+infoBody.getDouble("lng")+"}";
			return ResponseEntity.status(HttpStatus.OK).body(jsonReturn);
		}
		catch(Exception e){
			String jsonResponse = "{\"response\":400,\"desc\":\"No se han podido obtener las coordenadas\"}";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
	}
}
