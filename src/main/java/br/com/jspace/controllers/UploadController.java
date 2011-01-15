package br.com.jspace.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;

@Resource
public class UploadController {
	
	@Get
	@Path(value="/upload")
	public void upload(){
	}
	
	
	@Post
	@Path(value="/upload")
	public void uploadWarFile(UploadedFile war) {
		File warFile = new File(war.getFileName());
		
		try {
			IOUtils.copyLarge(war.getFile(), new FileOutputStream(warFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
