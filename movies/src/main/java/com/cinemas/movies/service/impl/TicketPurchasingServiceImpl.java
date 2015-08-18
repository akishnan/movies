package com.cinemas.movies.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import com.cinemas.movies.service.ShowTimeService;
import com.cinemas.movies.service.TicketPurchasingService;
import com.cinemas.movies.service.UserService;

@Service
public class TicketPurchasingServiceImpl implements TicketPurchasingService {

	@Autowired
	private ShowTimeService showTimeService;
	
	@Autowired
	private UserService userService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean purchaseTickets(long userId, long movieId, long theaterId, long screenId, Date showTime, int noOfTickets) {
		
		if (userService.isCreditCardValid(userId) && 
			showTimeService.hasTicketRemaining(movieId, theaterId, screenId, showTime, noOfTickets)) {
				return true;
		}
		return false;
	}
}
