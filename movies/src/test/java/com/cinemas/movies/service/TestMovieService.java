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
import com.cinemas.movies.entity.impl.MovieImpl;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestMovieService extends AbstractJUnit4SpringContextTests  {
	@Autowired
	private MovieBrowsingService movieBrowsingService;

	@Test
	public void testMovieId(){		
		Movie aMovie = movieBrowsingService.getMovieByName("Mission Impossible");
		Assert.assertEquals(true, aMovie.getId() == 1);
	}
	
	@Test
	public void testMovieGenre(){		
		Movie aMovie = movieBrowsingService.getMovieByName("Mission Impossible");
		Assert.assertEquals(true, aMovie.getMovieGenre().equalsIgnoreCase("action"));
	}
	
	@Test
	public void testMovieDirector(){		
		Movie aMovie = movieBrowsingService.getMovieByName("Mission Impossible");
		Assert.assertEquals(true, aMovie.getMovieDirector().equalsIgnoreCase("Christopher McQuarrie"));
	}
	
	@Test
	public void testMovieCast(){		
		Movie aMovie = movieBrowsingService.getMovieByName("Mission Impossible");
		Assert.assertEquals(true, aMovie.getMovieCast().equalsIgnoreCase("Tom Cruise, Jeremy Renner, Simon Pegg"));
	}

	@Test
	public void testMovieRanking(){		
		Movie aMovie = movieBrowsingService.getMovieByName("Mission Impossible");
		Assert.assertEquals(true, aMovie.getRanking() == 1);
	}
	
	@Test
	public void addAndGetMovie(){		
		//add a new movie
		MovieImpl aNewMovie = new MovieImpl();
		aNewMovie.setMovieName("Minions");
		aNewMovie.setMovieGenre("animated");
		aNewMovie.setMovieDirector("Pierre Coffin");
		aNewMovie.setMovieCast("Sandra Bullock,Jon Hamm,Michael Keaton");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date releaseDate=null;
		try {
			releaseDate = sdf.parse("2015-07-10");
		}
		catch(ParseException ex){
			ex.printStackTrace();
		}
		aNewMovie.setReleaseDate(releaseDate);
		aNewMovie.setRanking(3);
		
		Movie  addedMovie = movieBrowsingService.addMovie(aNewMovie);
		Assert.assertNotEquals(0, addedMovie.getId());		
		
		Movie found = movieBrowsingService.getMovieById(addedMovie.getId());
		Assert.assertEquals(found.getId(), addedMovie.getId());
		Assert.assertEquals(found.getMovieName(), addedMovie.getMovieName());
		Assert.assertEquals(found.getMovieDirector(), addedMovie.getMovieDirector());
		Assert.assertEquals(found.getRanking(), addedMovie.getRanking());

		
	}

}
