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
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.jspace.util.PropertiesUtil;

@Resource
public class UploadController {

	private Result result;
	private final Validator validator;

	public UploadController(Result result, Validator validator) {
		this.result = result;
		this.validator = validator;
	}

	@Get
	@Path(value="/upload")
	public void upload(){
	}


	@Post
	@Path(value="/upload")
	public void uploadWar(UploadedFile war) {
		try {
			PropertiesUtil props = new PropertiesUtil("src/main/resources/path.properties");
			String pathDeploy = props.getValor("tomcat.webapps");

			if (war == null){
				this.validator.add(new ValidationMessage("error", "Arquivo não pode ser nulo."));
			}else{
				if (war.getContentType() != "war"){
					this.validator.add(new ValidationMessage("error", "É permitido apenas o upload de arquivos .war "));
				}
				if (war.getFileName().trim().equals("")){
					this.validator.add(new ValidationMessage("error", "Arquivo necessita ter um nome"));
				}
			}
			validator.onErrorUsePageOf(UploadController.class).upload();

			File warFile = new File(pathDeploy + war.getFileName());
			IOUtils.copyLarge(war.getFile(), new FileOutputStream(warFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.result.forwardTo(this);
	}
}
