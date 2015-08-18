package com.cinemas.movies.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import com.cinemas.movies.service.CreditCardValidationService;
import com.cinemas.movies.service.ShowTimeService;
import com.cinemas.movies.service.TicketPurchasingService;
import com.cinemas.movies.service.UserService;

/**
 * TicketPurchasingServiceImpl interacts with UserService to validate user's Credit Card info and ShowTimeService
 * for ticket availability and ticket pricing.
 * 
 * @author Amit
 * @version 1.0
 * @since 2015-08-18
 * @see ShowTimeService
 * @see UserService
 */

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
			
				int ticketPrice = showTimeService.getTicketPrice(movieId, theaterId, screenId, showTime);
				int totalPrice = ticketPrice * noOfTickets;

				//TODO total price to be charged to CC.
				
				//TODO minus the noOfRemaningTickets
				
				return true;
		}
		return false;
	}
}
