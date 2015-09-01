package com.cinemas.movies.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.cinemas.movies.entity.Movie;
import com.cinemas.movies.entity.Theater;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestTicketPurchasingService extends AbstractJUnit4SpringContextTests  {
	
	
	@Autowired
	private TicketPurchasingService ticketPurchasingService;
	
	@Autowired
	private MovieBrowsingService movieBrowsingService;

	@Autowired
	private TheaterListingService theaterListingService;
	
	@Test
	public void testPurchaseTickets(){
		
		long userId = 1;
		
		//the below 4 attributes uniquely identify a given movie occurring at a particular theater/screen at particular time.
		
		//look up movie  from movie browsing service to get to it's id
		Movie aMovie = movieBrowsingService.getMovieByName("Mission Impossible");
		long movieId = aMovie.getId();
		
		//look up theater  from theater listing service to get to it's id
		Theater aTheater = theaterListingService.getTheaterByName("AMC Mercado 20");
		long theaterId = aTheater.getId();
		
		//default screen id
		long screenId = 1;
		
		Date showTime = null;
		//show time
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			showTime = sdf.parse("2018-12-31 18:00:00");
		}
		catch(ParseException ex){
			ex.printStackTrace();
		}	
		
		//the below should return true since the no of seats requested is 4 which less than the tickets remaining for the below show
		Assert.assertEquals(true, ticketPurchasingService.purchaseTickets(userId, movieId, theaterId, screenId, showTime, 4));
		
		//the below should return false - since the no of seats requested is 11 which is greater than ticket remaining for this given show
		Assert.assertEquals(false, ticketPurchasingService.purchaseTickets(userId, movieId, theaterId, screenId, showTime, 11));		
	}

}
