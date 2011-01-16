package br.jspace.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import br.com.jspace.util.PropertiesUtil;

public class PropertiesUtilTest {
	@Test
	public void loadProperties(){
		PropertiesUtil props = null;
		try {
			props = new PropertiesUtil("src/main/resources/path.properties");
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
		assertNotNull(props);
		assertEquals("/usr/local/tomcat6/", props.getValor("tomcat"));
		assertEquals("/usr/local/tomcat6/webapps/", props.getValor("tomcat.webapps"));
	}
}
