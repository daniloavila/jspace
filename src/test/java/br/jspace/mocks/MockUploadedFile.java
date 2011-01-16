package br.jspace.mocks;

import java.io.InputStream;

import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;

public class MockUploadedFile implements UploadedFile{

	private String contentType;
	private InputStream file;
	private String fileName;
	
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public InputStream getFile() {
		return file;
	}
	public void setFile(InputStream file) {
		this.file = file;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
