package com.cinemas.movies.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cinemas.movies.entity.Movie;
import com.cinemas.movies.entity.impl.MovieImpl;
import com.cinemas.movies.repository.MovieRepository;
import com.cinemas.movies.service.MovieBrowsingService;
import com.cinemas.movies.service.exception.InvalidFieldException;
import com.cinemas.movies.service.exception.MissingDataException;


@Service
public class MovieBrowsingServiceImpl implements MovieBrowsingService {
	
	private static final int MAX_MOVIE_NAME_LENGTH = 45;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MovieRepository movieRepository;
	
	
	/**
	 *  {@inheritDoc}
	 */
	@Override
	@Transactional
	public Movie addMovie(Movie aMovie) {
		if(StringUtils.isEmpty(aMovie.getMovieName())){			
			throw new MissingDataException("movie name is required");
		}	
		
		if (aMovie.getMovieName().length() > MAX_MOVIE_NAME_LENGTH) {
			throw new InvalidFieldException("movie name length exceeded than 45 characters");
		}
		
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
	@Transactional
	public List<Movie> getMovies() {
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
	@Transactional
	public List<Movie> sortMoviesByReleaseDate() {
		return movieRepository.sortMoviesByReleaseDate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public List<Movie> sortMoviesByRanking() {
		return movieRepository.sortMoviesByRanking();
	}


}
