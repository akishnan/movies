package com.cinemas.movies.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.cinemas.movies.entity.Movie;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestMovieService extends AbstractJUnit4SpringContextTests  {
	@Autowired
	private MovieBrowsingService movieBrowsingService;

	@Test
	public void testMovieId(){		
		Movie aMovie = movieBrowsingService.getMovieByName("mission impossible");
		Assert.assertEquals(true, aMovie.getId() == 1);
	}
	
	@Test
	public void testMovieGenre(){		
		Movie aMovie = movieBrowsingService.getMovieByName("mission impossible");
		Assert.assertEquals(true, aMovie.getMovieGenre().equalsIgnoreCase("action"));
	}
	
	@Test
	public void testMovieDirector(){		
		Movie aMovie = movieBrowsingService.getMovieByName("mission impossible");
		Assert.assertEquals(true, aMovie.getMovieDirector().equalsIgnoreCase("Christopher McQuarrie"));
	}
	
	@Test
	public void testMovieCast(){		
		Movie aMovie = movieBrowsingService.getMovieByName("mission impossible");
		Assert.assertEquals(true, aMovie.getMovieCast().equalsIgnoreCase("Tom Cruise, Jeremy Renner, Simon Pegg"));
	}

	@Test
	public void testMovieRanking(){		
		Movie aMovie = movieBrowsingService.getMovieByName("mission impossible");
		Assert.assertEquals(true, aMovie.getRanking() == 1);
	}

}
