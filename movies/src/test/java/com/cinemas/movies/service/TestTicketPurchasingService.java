package com.cinemas.movies.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestTicketPurchasingService extends AbstractJUnit4SpringContextTests  {
	@Autowired
	private TicketPurchasingService ticketPurchasingService;
	
	
	@Test
	public void testPurchaseTickets(){
		
		long userId = 1;
		
		//the below 4 attributes uniquely identify a given movie occurring at a particular theater/screen at particular time.
		long movieId = 1;
		long theaterId = 1;
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
		
		Assert.assertEquals(true, ticketPurchasingService.purchaseTickets(userId, movieId, theaterId, screenId, showTime, 4));
		
		//the below should return false - since the no of seats requested is 11 which is greater than ticket remaining for this given show
		Assert.assertEquals(false, ticketPurchasingService.purchaseTickets(userId, movieId, theaterId, screenId, showTime, 11));		
	}

}
