package com.cinemas.movies.service;

import com.cinemas.movies.entity.User;

public interface UserService {
	
	/**
	 * look up user by Id
	 * @param userId unique id to look up user
	 * @return User object
	 */
	User getUserById(long userId);		
	
	/**
	 * checks if the user has valid login credentials 
	 * @param userId unique id to look up user
	 * @param username username to validate
	 * @param password password to validate
	 * @return true if the user has valid username/password.
	 */
	boolean isValidUser(long userId, String username, String password);
	
	/**
	 * check if the stored user card is valid by communicating with CreditCardValidationService 
	 * @param userId unique id to look up user
	 * @return true if it is valid
	 * @see CreditCardValidationService
	 */
	boolean isCreditCardValid(long userId);
}
