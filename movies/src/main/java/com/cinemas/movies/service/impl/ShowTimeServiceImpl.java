package com.cinemas.movies.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import com.cinemas.movies.entity.ShowTime;
import com.cinemas.movies.entity.impl.ShowTimeImpl;
import com.cinemas.movies.service.ShowTimeService;

/**
 * 
 * @author Amit
 *
 */

@Service
public class ShowTimeServiceImpl implements ShowTimeService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ShowTime getShowTime(long movieId, long theaterId) {
		// TODO Auto-generated method stub
		return new ShowTimeImpl(movieId, theaterId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ShowTime> getMoviesPlayingInTheater(long theaterId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ShowTime> getTheatersPlayingMovie(long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasTicketRemaining(long movieId, long theaterId, long screenId, Date showTime, int noOfTickets) {
		ShowTime aShowTime = new ShowTimeImpl(movieId, theaterId);
		if (aShowTime.getTicketsRemaining() > noOfTickets) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getTicketPrice(long movieId, long theaterId, long screenId, Date showTime) {
		ShowTime aShowTime = new ShowTimeImpl(movieId, theaterId);
		return aShowTime.getTicketPrice();
	}
}
