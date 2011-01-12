package br.com.jspace.models;

import br.com.jspace.models.commons.Role;

@javax.persistence.Entity
public class User extends Entity {
	
	private String name;
	private String password;
	private String email;
	private Role role;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
