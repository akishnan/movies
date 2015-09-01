package com.cinemas.movies.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.cinemas.movies.entity.Movie;
import com.cinemas.movies.entity.Theater;
import com.cinemas.movies.entity.impl.TheaterImpl;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestTheaterService extends AbstractJUnit4SpringContextTests  {
	@Autowired
	private TheaterListingService theaterListingService;

	@Test
	public void testTheaterId(){		
		Theater aTheater = theaterListingService.getTheaterByName("AMC Mercado 20");
		Assert.assertEquals(true, aTheater.getId() == 1);
	}
	
	@Test
	public void testTheaterZipCode(){		
		Theater aTheater = theaterListingService.getTheaterByName("AMC Mercado 20");
		Assert.assertEquals(true, aTheater.getTheaterZipCode() == 95050);
	}
	
	@Test
	public void testNumberOfScreens(){		
		Theater aTheater = theaterListingService.getTheaterByName("AMC Mercado 20");
		Assert.assertEquals(true, aTheater.getNumberOfScreens() == 20);
	}
	
	@Test
	public void addAndGetTheater(){
		TheaterImpl aNewTheater = new TheaterImpl();
		aNewTheater.setTheaterName("CENTURY 20 DOWNTOWN REDWOOD CITY AND XD");
		aNewTheater.setTheaterAddrLine1("825 Middlefield Rd.");
		aNewTheater.setTheaterAddrLine2("");
		aNewTheater.setTheaterCity("Redwood City");
		aNewTheater.setTheaterState("CA");
		aNewTheater.setTheaterZipCode(94063);
		aNewTheater.setNumberOfScreens(20);
		
		Theater  addedTheater = theaterListingService.addTheater(aNewTheater);
		Assert.assertNotEquals(0, addedTheater.getId());	
		
		Theater found = theaterListingService.getTheaterId(addedTheater.getId());
		Assert.assertEquals(found.getId(), addedTheater.getId());	
		Assert.assertEquals(found.getTheaterName(), addedTheater.getTheaterName());	
		Assert.assertEquals(found.getTheaterCity(), addedTheater.getTheaterCity());	
		Assert.assertEquals(found.getTheaterZipCode(), addedTheater.getTheaterZipCode());
		Assert.assertEquals(found.getNumberOfScreens(), addedTheater.getNumberOfScreens());		
	}
}
