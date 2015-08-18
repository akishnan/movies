package com.cinemas.movies.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestUserService extends AbstractJUnit4SpringContextTests  {
	@Autowired
	private UserService userService;
	
	
	@Test
	public void testLogin(){
		Assert.assertEquals(true, userService.isValidUser(1, "foo", "foo"));
		Assert.assertEquals(false, userService.isValidUser(1, "foo", "bar"));
	}

	@Test
	public void testCreditCard(){
		Assert.assertEquals(true, userService.isCreditCardValid(1));
	}
	

}
