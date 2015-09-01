package com.cinemas.movies.repository;

import java.util.Date;
import java.util.List;

import com.cinemas.movies.entity.ShowTime;;

public interface ShowTimeRepository {

	/**
	 * look up a showtime by id
	 * @param showTimeId
	 * @return showTime  object if found
	 */
	ShowTime getShowTimeById(long showTimeId);
	
	
	/**
	 * look up a showtime by movie ID , theater ID, screenID , showTime
	 * @param showTimeId
	 * @return showTime  object if found
	 */
	ShowTime getShowTime(long movieId, long theaterId, long screenId, Date showTime);

	
	/**
	 * show a list of theaters + show times playing  a particular movie
	 * @param movieId - the movieId id to filter by
	 * @return list of showtimes
	 */
	List<ShowTime> getTheatersPlayingMovie(long movieId);
	
	
	/**
	 * show a list of movie + show times playing in a particular theater 
	 * @param theaterId - the theater id to filter by
	 * @return list of showtimes
	 */
	List<ShowTime> getMoviesPlayingInTheater(long theaterId);
}
