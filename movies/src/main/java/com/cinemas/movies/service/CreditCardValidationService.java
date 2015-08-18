package com.cinemas.movies.service;

import java.util.Date;

public interface CreditCardValidationService {
	/**
	 * this method validates the creditCardNumber and checks the expiry date is greater than the current date
	 * @param creditCardNumber the credit card number to check
	 * @param expiryDate the expiry date on the card
	 * @return true if the card is valid
	 */
	boolean isValidCreditCard(String creditCardNumber, Date expiryDate);
}
