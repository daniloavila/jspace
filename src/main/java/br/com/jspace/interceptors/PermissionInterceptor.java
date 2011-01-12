package br.com.jspace.interceptors;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.jspace.controllers.IndexController;
import br.com.jspace.controllers.UserController;
import br.com.jspace.models.User;
import br.com.jspace.models.commons.Role;

@Intercepts
@RequestScoped
public class PermissionInterceptor implements Interceptor {

	private Result result;
	private HttpSession session;

	public PermissionInterceptor(Result result, HttpSession session) {
		this.result = result;
		this.session = session;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean accepts(ResourceMethod method) {
		return !Arrays.asList(IndexController.class).contains(method.getMethod().getDeclaringClass());
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) {
		if (isAcessoMetodo(method) && isAcessoController(method)) {
			stack.next(method, resourceInstance);
		} else {
			result.redirectTo(UserController.class).negado();
		}
	}

	private User getUser() {
		return (User) session.getAttribute("user");
	}

	private boolean isAcessoMetodo(ResourceMethod method) {
		Permission permissaoList = method.getMethod().getAnnotation(Permission.class);
		return isExistePermissao(permissaoList);
	}

	private boolean isAcessoController(ResourceMethod method) {
		Permission permissaoList = method.getResource().getType().getAnnotation(Permission.class);		
		return isExistePermissao(permissaoList);
	}

	private boolean isExistePermissao(Permission permissaoList) {
		User user = this.getUser();

		if (permissaoList != null) { // Com permissão anotada. Verificar!
			for (Role perfil : permissaoList.value()) {
				if (perfil.equals(user.getRole())) {
					return true;
				}
			}
		} else { // Sem permissão anotada. Continue!
			return true;
		}

		return false;
	}

}