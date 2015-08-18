package com.cinemas.movies.service;

import java.util.Date;

public interface TicketPurchasingService {

	/**
	 * this method makes use of two services userService to validate credit card and 
	 * showTimeService to see if there are tickets remaining.
	 * 
	 * @param userId      user purchasing ticket
	 * @param movieId     uniquely identifies a movie
	 * @param theaterId   uniquely identifies a theater
	 * @param screenId    uniquely identifies a screen when the theater has multiple screens
	 * @param showTime    the time of show
	 * @param noOfTickets the number of tickets to purchase.
	 * @return true if the above requirements has been meet
	 */
	boolean purchaseTickets(long userId, long movieId, long theaterId, long screenId, Date showTime, int noOfTickets);
}
