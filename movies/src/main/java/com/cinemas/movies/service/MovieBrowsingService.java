package com.cinemas.movies.service;


import java.util.List;
import com.cinemas.movies.entity.Movie;


public interface MovieBrowsingService {
	
	/**
	 * filter movie by name
	 * @param movieName name of movie to filter by
	 * @return Movie object
	 */
	Movie getMovieByName(String movieName);

	//get a list of all movies sorted by release date
	
	/**
	 * get a list of all movies
	 * @return list of all movies
	 */
	List<Movie> getMovies();
	
	/**
	 * get a list of movies filtered by movie genre (E.g. action, comedy, romance , etc)
	 * @param movieGenre the name of genre to filter by
	 * @return filtered list of movies by genre
	 */
	List<Movie> getMoviesByGenre(String movieGenre);

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