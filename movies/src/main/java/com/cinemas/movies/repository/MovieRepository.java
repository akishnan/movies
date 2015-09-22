package com.cinemas.movies.repository;

import java.util.List;

import com.cinemas.movies.entity.Movie;

public interface MovieRepository {
	/**
	 * 
	 * @param movie
	 * @return the id of the newly added movie
	 */
	long addMovie(Movie aMovie);
	
	/**
	 * look up a movie by id
	 * @param movieId
	 * @return movie object if found
	 */
	Movie getMovieById(long movieId);
	
	/**
	 * look up a movie by name
	 * @param movieName
	 * @return  movie object if found
	 */
	Movie getMovieByName(String movieName);

	/**
	 * returns a list of movies
	 * @return
	 */
	List<Movie> getMovies();
	
	/**
	 * get a list of movies sorted by release dates
	 * @return a list of movies sorted by release dates
	 */
	List<Movie> sortMoviesByReleaseDate();
	
	//
	/**
	 * get a list of movies sorted by ranking
	 * @return a list of movies sorted by ranking
	 */
	List<Movie> sortMoviesByRanking();
}