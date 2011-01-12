package br.com.jspace.controllers;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.jspace.models.User;
import br.com.jspace.repositories.UserRepository;

@Resource
public class UserController {

	private final Result result;
	private final UserRepository repository;
	private final Validator validator;
	
	public UserController(Result result, UserRepository repository, Validator validator) {
		this.result = result;
		this.repository = repository;
		this.validator = validator;
	}
	
	@Get
	@Path("/users")
	public List<User> index() {
		return repository.findAll();
	}
	
	@Post
	@Path("/users")
	public void create(User user) {
		validator.validate(user);
		validator.onErrorUsePageOf(this).newUser();
		repository.create(user);
		result.include("message", "Usuário removido com sucesso!")
		.redirectTo(this).index();
	}
	
	@Get
	@Path("/users/new")
	public User newUser() {
		return new User();
	}
	
	@Put
	@Path("/users")
	public void update(User user) {
		validator.validate(user);
		validator.onErrorUsePageOf(this).edit(user);
		repository.update(user);
		result.redirectTo(this).index();
	}
	
	@Get
	@Path("/users/{user.id}/edit")
	public User edit(User user) {
		return repository.find(user.getId());
	}

	@Get
	@Path("/users/{user.id}")
	public User show(User user) {
		System.out.println("show");
		return repository.find(user.getId());
	}

	@Delete
	@Path("/users/{user.id}")
	public void destroy(User user) {
		repository.destroy(repository.find(user.getId()));
		result.include("message", "Usuário removido com sucesso!")
		.redirectTo(this).index();  
	}
	
	@Get
	@Path("/user/negado")
	public void negado() {
		result.include("message", "Ops! Você não pode fazer isso! (:");
	}
}
