package br.com.jspace.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	private Properties props;

	public PropertiesUtil(String propertiesName) throws IOException {
		props = new Properties();
		InputStream in = new FileInputStream(propertiesName);

		try{
			props.load(in);
		}finally{
			in.close();
		}
	}

	public String getValor(String chave) {
		return (String) props.getProperty(chave);
	}
}
