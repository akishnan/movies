package com.cinemas.movies.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemas.movies.entity.ShowTime;
import com.cinemas.movies.entity.impl.ShowTimeImpl;
import com.cinemas.movies.repository.ShowTimeRepository;
import com.cinemas.movies.service.ShowTimeService;

/**
 * 
 * @author Amit
 *
 */

@Service
public class ShowTimeServiceImpl implements ShowTimeService {	
	
	
	@Autowired
	private ShowTimeRepository showTimeRepository;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public ShowTime getShowTimeById(long showTimeId) {
		return showTimeRepository.getShowTimeById(showTimeId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ShowTime getShowTime(long movieId, long theaterId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public List<ShowTime> getMoviesPlayingInTheater(long theaterId) {
		return showTimeRepository.getMoviesPlayingInTheater(theaterId);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public List<ShowTime> getTheatersPlayingMovie(long movieId) {
		return  showTimeRepository.getTheatersPlayingMovie(movieId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public boolean hasTicketRemaining(long movieId, long theaterId, long screenId, Date showTime, int noOfTickets) {
		ShowTime aShowTime = showTimeRepository.getShowTime(movieId, theaterId, screenId, showTime);
		if (aShowTime.getTicketsRemaining() > noOfTickets) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public int getTicketPrice(long movieId, long theaterId, long screenId, Date showTime) {
		ShowTime aShowTime = showTimeRepository.getShowTime(movieId, theaterId, screenId, showTime);
		return aShowTime.getTicketPrice();
	}

	@Override
	@Transactional
	public List<ShowTime> getAllShowTimes() {
		return  showTimeRepository.getAllShowTimes();
	}


}
