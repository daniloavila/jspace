package br.com.jspace.interceptors;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import br.com.jspace.models.commons.Role;

@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
	
	Role[] value();
	
}
