package com.cinemas.movies.service;

import java.util.List;

import com.cinemas.movies.entity.Theater;

public interface TheaterListingService {
	
	
	/**
	 * add a new movie object
	 * @param aMovie
	 * @return a movie object
	 */
	Theater addTheater(Theater aTheater);
	
	
	/**
	 * return a Theater object by matching it's id
	 * @param theaterId
	 * @return a theater object
	 */
	Theater getTheaterId(long theaterId);
	

	//get theater by name
	/**
	 * filter by theater name
	 * @param theaterName name of theater
	 * @return a theater object
	 */
	Theater getTheaterByName(String theaterName);
	
	/**
	 * get theater by zipCode
	 * @param zipCode  identifies the location to filter by
	 * @return a theater object
	 */
	Theater getTheaterByZipCode(int zipCode);
	
	/**
	 * get a list of theaters
	 * @return list of theaters
	 */
	List<Theater> getAllTheaters();	
}