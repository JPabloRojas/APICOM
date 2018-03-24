package cl.apicom.spring.backend.auxentities;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


/*
 * Clase para la creacion de documentos PDF que consta de distintos metodos para formato y posibilidades
 * de añadir componentes como titulos, subtitulos o tablas.
 */
public class CreatePDF {
	
	private static Font TIME_ROMAN = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
	private static Font TIME_ROMAN_SMALL = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

	/**
	 * 
	 * @param file
	 * @param nombre_usuario
	 * @return
	 */
	public Document createPDF(String file, String nombre_usuario) {

		Document document = null;

		try {
			document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();

			addMetaData(document);

			addTitlePage(document,nombre_usuario);

			createTable(document);

			document.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;

	}

	private void addMetaData(Document document) {
		document.addTitle("Generate PDF report");
		document.addSubject("Generate PDF report");
		document.addAuthor("Java Honk");
		document.addCreator("Java Honk");
	}

	/**
	 * 
	 * @param document
	 * @param nombre_usuario
	 * @throws DocumentException
	 */
	private void addTitlePage(Document document, String nombre_usuario)
			throws DocumentException {

		Paragraph preface = new Paragraph();
		creteEmptyLine(preface, 1);
		preface.add(new Paragraph("Reporte de despachos usuario: "+nombre_usuario, TIME_ROMAN));

		creteEmptyLine(preface, 1);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		preface.add(new Paragraph("Reporte creado en "
				+ simpleDateFormat.format(new Date()), TIME_ROMAN_SMALL));
		document.add(preface);

	}
	
	/**
	 * 
	 * @param paragraph
	 * @param number
	 */
	private void creteEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
	
	/**
	 * 
	 * @param document
	 * @throws DocumentException
	 */
	private void createTable(Document document) throws DocumentException {
		Paragraph paragraph = new Paragraph();
		creteEmptyLine(paragraph, 2);
		document.add(paragraph);
		PdfPTable table = new PdfPTable(5);

		PdfPCell c1 = new PdfPCell(new Phrase("Tipo"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Fecha despacho"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Fecha entrega"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Direccion de entrega"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Pago por producto"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		table.setHeaderRows(1);

		for (int i = 0; i < 5; i++) {
			table.setWidthPercentage(100);
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell("Carta");
			table.addCell("23/03/05");
			table.addCell("23/05/06");
			table.addCell("Direccion");
			table.addCell("2000");
		}

		document.add(table);
	}

}
