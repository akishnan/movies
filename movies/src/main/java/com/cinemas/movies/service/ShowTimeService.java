package com.cinemas.movies.service;

import java.util.Date;
import java.util.List;

import com.cinemas.movies.entity.ShowTime;

public interface ShowTimeService {
	
	/**
	 * look up showtime for a particular movie in a particular theater.
	 * @param movieId uniquely identifies a movie
	 * @param theaterId unique identifies a theater 
	 * @return ShowTime Object
	 */
	ShowTime getShowTime(long movieId, long theaterId);	
	
	/**
	 * check if there is capacity based on remaining tickets
	 * for a show time (uniquely identified by below 4 attributes)
	 * 
	 * @param movieId uniquely identifies a movie
	 * @param theaterId uniquely identifies a theater 
	 * @param screenId uniquely identifies a screen when theater has multiple screens
	 * @param showTime the time of show
	 * @param noOfTickets number of tickets needed
	 * @return true if ticket remaining is greater than noOfTickets
	 */
	boolean hasTicketRemaining(long movieId, long theaterId, long screenId, Date showTime, int noOfTickets);
	

	/**
	 * get the price of each ticket
	 * for a show time (uniquely identified by below 4 attributes)
	 * 
	 * @param movieId uniquely identifies a movie
	 * @param theaterId uniquely identifies a theater 
	 * @param screenId uniquely identifies a screen when theater has multiple screens
	 * @param showTime the time of show
	 * @return the ticket price for the given show.
	 */
	int getTicketPrice(long movieId, long theaterId, long screenId, Date showTime);

	/**
	 * show a list of movie + show times playing in a particular theater 
	 * @param theaterId - the theater id to filter by
	 * @return list of showtimes
	 */
	List<ShowTime> getMoviesPlayingInTheater(long theaterId);
	
	/**
	 * show a list of theaters + show times playing  a particular movie
	 * @param movieId - the movieId id to filter by
	 * @return list of showtimes
	 */
	List<ShowTime> getTheatersPlayingMovie(long movieId);	
}
