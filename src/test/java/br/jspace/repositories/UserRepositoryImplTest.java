package br.jspace.repositories;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.jspace.repositories.UserRepositoryImpl;

public class UserRepositoryImplTest {

    @Test public void fakeTest() {
  		assertNotNull("put something real.", new UserRepositoryImpl(null));
  	}
}

