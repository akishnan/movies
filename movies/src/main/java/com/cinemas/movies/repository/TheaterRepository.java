package com.cinemas.movies.repository;

import java.util.List;

import com.cinemas.movies.entity.Theater;

public interface TheaterRepository {

	/**
	 * 
	 * @param aTheater object
	 * @return the id of the newly added theater
	 */
	long addTheater(Theater aTheater);
	
	/**
	 * look up a theater by id
	 * @param theaterId
	 * @return theater object if found
	 */
	Theater getTheaterById(long theaterId);
	
	/**
	 * look up a theater by name
	 * @param theaterName
	 * @return  theater object if found
	 */
	Theater getTheaterByName(String theaterName);
	
	/**
	 * returns a list of all theaters
	 * @return
	 */
	List<Theater> getTheaters();
}
