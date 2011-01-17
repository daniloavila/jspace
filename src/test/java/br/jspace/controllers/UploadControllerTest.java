package br.jspace.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.caelum.vraptor.validator.ValidationException;
import br.com.jspace.controllers.UploadController;
import br.jspace.mocks.MockUploadedFile;

public class UploadControllerTest {
	
	private MockResult result;
	private MockValidator validator;
	private MockUploadedFile uploadedFile;
	
	@Before
	public void setUp(){
		this.result = new MockResult();
		this.validator = new MockValidator();
		this.uploadedFile = new MockUploadedFile();
	}

	@Test
	public void uploadWar() throws FileNotFoundException, IOException{
		uploadedFile.setContentType("war");
		uploadedFile.setFileName("teste");
		uploadedFile.setFile(new FileInputStream(new File("pom.xml")));
		
		UploadController upload = new UploadController(result, validator);
		upload.uploadWar(uploadedFile);
		assertFalse(validator.hasErrors());
	}
	
	@Test(expected=ValidationException.class)
	public void uploadWarWithBlankName() throws FileNotFoundException, IOException{
		uploadedFile.setContentType("war");
		uploadedFile.setFileName("");
		uploadedFile.setFile(new FileInputStream(new File("pom.xml")));
		
		UploadController upload = new UploadController(result, validator);
		upload.uploadWar(uploadedFile);
		assertTrue(validator.hasErrors());
	}
	
	@Test(expected=ValidationException.class)
	public void uploadNotWarFile() throws FileNotFoundException, IOException{
		uploadedFile.setContentType("jpeg");
		uploadedFile.setFileName("teste");
		uploadedFile.setFile(new FileInputStream(new File("pom.xml")));
		
		UploadController upload = new UploadController(result, validator);
		upload.uploadWar(uploadedFile);
		
		assertTrue(validator.hasErrors());
		assertNotNull(result.included("erros"));
		assertEquals(1, result.included().size());
	}
	
	@Test(expected=ValidationException.class)
	public void uploadNullWar() throws FileNotFoundException, IOException{
		UploadController upload = new UploadController(result, validator);
		upload.uploadWar(null);
		
		assertTrue(validator.hasErrors());
	}
}
