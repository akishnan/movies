package com.cinemas.movies.repository;

import java.util.Random;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.cinemas.movies.entity.Movie;
import com.cinemas.movies.entity.impl.MovieImpl;


@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestMovieRepository extends AbstractTransactionalJUnit4SpringContextTests{
	@Autowired
	private MovieRepository moviesRepository;

	//@Rollback(false)
	@Test
	public void getMovieById(){
		//look up movie by Id
		Movie found = moviesRepository.getMovieById(1);
		Assert.assertEquals(found.getMovieName(), "Mission Impossible");		
	}
	
	@Test
	public void getMovieByName(){		
		//look up movie by name
		Movie found = moviesRepository.getMovieByName("Inside Out");
		Assert.assertEquals(found.getId(), 2);		
	}
	
	@Test
	public void getMovies(){		
		//get all movies
		List<Movie> movieList = moviesRepository.getMovies();
		Assert.assertTrue(movieList.size() > 0);
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
		
		long  addedMovieId = moviesRepository.addMovie(aNewMovie);
		System.out.println("movie added id "+addedMovieId);
		Assert.assertNotEquals(0, addedMovieId);		
		
		Movie found = moviesRepository.getMovieById(addedMovieId);
		Assert.assertEquals(found.getId(), addedMovieId);
		Assert.assertEquals(found.getMovieName(), aNewMovie.getMovieName());
		Assert.assertEquals(found.getMovieDirector(), aNewMovie.getMovieDirector());
		Assert.assertEquals(found.getReleaseDate(), aNewMovie.getReleaseDate());
	}
	
	
	
}
