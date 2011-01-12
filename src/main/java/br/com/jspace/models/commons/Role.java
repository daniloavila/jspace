package br.com.jspace.models.commons;

import java.util.ArrayList;
import java.util.Collection;

public enum Role {

	MEMBER, ADMIN;

	public static Collection<Role> loadAll() {
		Collection<Role> perfis = new ArrayList<Role>();

		for (Role perfil : values()) {
			perfis.add(perfil);
		}

		return perfis;
	}

}