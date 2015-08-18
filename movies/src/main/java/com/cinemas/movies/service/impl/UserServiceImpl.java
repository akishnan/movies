package com.cinemas.movies.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemas.movies.entity.User;
import com.cinemas.movies.entity.impl.UserImpl;
import com.cinemas.movies.service.CreditCardValidationService;
import com.cinemas.movies.service.UserService;

/**
 * UserServiceImpl validates if the username/password is valid combination
 * it also calls into CreditCardValidationService to validate the users credit card info
 * 
 * @author Amit
 * @version 1.0
 * @since 2015-08-18
 * @see CreditCardValidationService
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private CreditCardValidationService creditCardValidationService;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getUserById(long userId) {
		// TODO Auto-generated method stub
		return new UserImpl(userId);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isValidUser(long userId, String username, String password) {

		if (userId == 1) {
			User aUser = new UserImpl(userId);
			if (aUser.getUserName().equals(username) && aUser.getUserPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isCreditCardValid(long userId) {
		User aUser = new UserImpl(userId);
		if (creditCardValidationService.isValidCreditCard(aUser.getCreditCardNumber(), aUser.getCreditCardExpiryDate())) {
			return true;
		}
		return false;
	}
	
}
