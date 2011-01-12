package br.com.jspace.repositories;

import java.util.List;

import br.com.jspace.models.User;

public interface UserRepository {
	/*
	 * Delete the methods you don't want to expose
	 */
	 
	void create(User entity);
	
	void update(User entity);
	
	void destroy(User entity);
	
	User find(Long id);
	
	List<User> findAll();

}
