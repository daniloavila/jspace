package br.com.jspace.controllers;

import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.jspace.models.User;
import br.com.jspace.models.commons.Role;


@Resource
public class IndexController {

	private HttpSession session;

	public IndexController(HttpSession session) {
		this.session = session;
	}

	@Get
	@Path("/")
	public void index() {
		session.setAttribute("user", this.getUsuario());
	}
	
	private User getUsuario() {
		User usuario = new User();
		usuario.setName("Washington Botelho");
		usuario.setRole(Role.MEMBER);
		return usuario;
	}

}