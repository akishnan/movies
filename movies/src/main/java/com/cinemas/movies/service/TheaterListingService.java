package com.cinemas.movies.service;

import java.util.List;

import com.cinemas.movies.entity.Theater;

public interface TheaterListingService {

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
