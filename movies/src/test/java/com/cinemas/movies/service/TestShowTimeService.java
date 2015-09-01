package com.cinemas.movies.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.cinemas.movies.entity.Movie;
import com.cinemas.movies.entity.ShowTime;
import com.cinemas.movies.entity.Theater;



@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestShowTimeService extends AbstractJUnit4SpringContextTests  {
	@Autowired
	private ShowTimeService showTimeService;

	/*@Test
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
	}*/
	
	@Test
	public void testMovieName(){		
		ShowTime aShowTime = showTimeService.getShowTimeById(1);
		Movie aMovie = aShowTime.getMovie();
		Assert.assertEquals(true, aMovie.getMovieName().equalsIgnoreCase("Mission Impossible"));
	}

	@Test
	public void testTheaterName(){		
		ShowTime aShowTime = showTimeService.getShowTimeById(2);
		Theater aTheater = aShowTime.getTheater();
		Assert.assertEquals(true, aTheater.getTheaterName().equalsIgnoreCase("CENTURY 20 DOWNTOWN REDWOOD CITY AND XD"));
	}
	
	@Test
	public void testTheatersPlayingMovie(){		
		//get theaters playing movie by id 5
		List<ShowTime> showTimes	= showTimeService.getTheatersPlayingMovie(5);
		Assert.assertEquals(true, showTimes.size() > 0);
	}
	
	@Test
	public void testMoviesPlayingInTheater(){		
		//get movies playing in theater id 1
		List<ShowTime> showTimes	= showTimeService.getMoviesPlayingInTheater(1);
		Assert.assertEquals(true, showTimes.size() > 0);
	}

}