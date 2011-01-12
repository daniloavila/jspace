package br.com.jspace.repositories;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;
import br.com.jspace.models.User;

@Component
public class UserRepositoryImpl 
    extends Repository<User, Long>
    implements UserRepository {

	public UserRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}
}
