package com.cinemas.movies.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.cinemas.movies.entity.ShowTime;



@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestShowTimeService extends AbstractJUnit4SpringContextTests  {
	@Autowired
	private ShowTimeService showTimeService;

	@Test
	public void testScreenId(){		
		ShowTime aShowTime = showTimeService.getShowTime(1,1);
		Assert.assertEquals(true, aShowTime.getScreenId() == 1);
	}
	
	@Test
	public void testShowTime(){		
		ShowTime aShowTime = showTimeService.getShowTime(1,1);
		Date toTestShowTime=null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			toTestShowTime = sdf.parse("2018-12-31 18:00:00");
		}
		catch(ParseException ex){
			ex.printStackTrace();
		}
		
		Assert.assertEquals(true, aShowTime.getShowTime().compareTo(toTestShowTime) == 0);
	}
}
