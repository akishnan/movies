package com.cinemas.movies.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cinemas.movies.entity.Movie;
import com.cinemas.movies.entity.impl.MovieImpl;
import com.cinemas.movies.service.MovieBrowsingService;

@Service
public class MovieBrowsingServiceImpl implements MovieBrowsingService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Movie getMovieByName(String movieName) {
		MovieImpl aMovieImpl = new MovieImpl(movieName);
		return aMovieImpl;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Movie> getMovies() {
		//TODO load movies from the database
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Movie> getMoviesByGenre(String movieGenre) {
		//TODO load movies from the database filtered by genre
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Movie> sortMoviesByReleaseDate() {
		//TODO load movies from the database sorted by release date
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Movie> sortMoviesByRanking() {
		//TODO load movies from the database sorted by ranking
		return null;
	}
}
