package com.cinemas.movies.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemas.movies.entity.Movie;
import com.cinemas.movies.entity.impl.MovieImpl;
import com.cinemas.movies.repository.MovieRepository;
import com.cinemas.movies.service.MovieBrowsingService;


@Service
public class MovieBrowsingServiceImpl implements MovieBrowsingService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MovieRepository movieRepository;
	
	
	/**
	 *  {@inheritDoc}
	 */
	@Override
	@Transactional
	public Movie addMovie(Movie aMovie) {
		long movieId =  movieRepository.addMovie(aMovie);
		return getMovieById(movieId);
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional//at method level
	public Movie getMovieById(long movieId) {
		return movieRepository.getMovieById(movieId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Movie getMovieByName(String movieName) {
		return movieRepository.getMovieByName(movieName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Movie> getMovies() {
		//TODO load movies from the database
		return movieRepository.getMovies();
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
