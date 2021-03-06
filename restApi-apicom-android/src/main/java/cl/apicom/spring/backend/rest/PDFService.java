package cl.apicom.spring.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.apicom.spring.backend.auxentities.CreatePDF;
import cl.apicom.spring.backend.auxentities.RequestID;
import cl.apicom.spring.backend.entities.Detail;
import cl.apicom.spring.backend.repository.DetailRepository;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@RequestMapping("/pdf")
public class PDFService {
	
	@Autowired
	private DetailRepository detailrepository;
	
	/*
	 * Plataforma: Android
	 * Tipo: GET
	 * Descripción: Servicio que permite descargar pdf resumen de detalles para un usuario en especifico.
	 */
	@RequestMapping(value = "/download",method = RequestMethod.GET)
	public void downloadPDF(HttpServletRequest request, HttpServletResponse response) throws IOException {
 
		final ServletContext servletContext = request.getSession().getServletContext();
	    final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
	    final String temperotyFilePath = tempDirectory.getAbsolutePath();
 
	    String fileName = "DetalleUsuario.pdf";
	    response.setContentType("application/pdf");
	    response.setHeader("Content-disposition", "attachment; filename="+ fileName);
 
	    try {
	    	CreatePDF createpdf = new CreatePDF();
	        createpdf.createPDF(temperotyFilePath+"\\"+fileName,"Test");
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        baos = convertPDFToByteArrayOutputStream(temperotyFilePath+"\\"+fileName);
	        OutputStream os = response.getOutputStream();
	        baos.writeTo(os);
	        os.flush();
	    } catch (Exception e1) {
	        e1.printStackTrace();
	    }
 
	}
	
	/*
	 * Descripcion: Metodo complementario para descarga de pdf que permite convertir el archivo en un ByteArray
	 * para permitir su salida y descarga.
	 */
	private ByteArrayOutputStream convertPDFToByteArrayOutputStream(String fileName) {
 
		InputStream inputStream = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
 
			inputStream = new FileInputStream(fileName);
			byte[] buffer = new byte[1024];
			baos = new ByteArrayOutputStream();
 
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}
 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return baos;
	}
	
	/*@RequestMapping(value = "/test",method = RequestMethod.POST)
	public ResponseEntity<?> test(@RequestBody RequestID resource){
		long id = resource.getId();
		List<Detail> details = detailrepository.getDetailUserMonth(id);
		return ResponseEntity.status(HttpStatus.OK).body(details);
		
	}*/
}
