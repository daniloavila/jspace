package br.jspace.controllers;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.jspace.controllers.UserController;

public class UserControllerTest {

	@Test public void fakeTest() {
		assertNotNull("put something real.", new UserController(null, null, null));
 	}
}
