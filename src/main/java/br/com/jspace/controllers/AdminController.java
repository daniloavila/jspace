package br.com.jspace.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.jspace.interceptors.Permission;
import br.com.jspace.models.commons.Role;

@Resource
@Permission(Role.ADMIN)
public class AdminController {

	private Result result;

	public AdminController(Result result) {
		this.result = result;
	}

	@Get
	@Path("/admin")
	public void admin() {
		result.include("message", "Seja bem-vindo ao painel administrativo");
	}

}