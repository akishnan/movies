package com.cinemas.movies.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.cinemas.movies.entity.Theater;

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
		Assert.assertEquals(true, aTheater.getTheaterZipCode() == 95054);
	}
	
	@Test
	public void testNumberOfScreens(){		
		Theater aTheater = theaterListingService.getTheaterByName("AMC Mercado 20");
		Assert.assertEquals(true, aTheater.getNumberOfScreens() == 20);
	}
}
