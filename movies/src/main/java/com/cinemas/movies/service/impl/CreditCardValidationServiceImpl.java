package com.cinemas.movies.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;
import com.cinemas.movies.service.CreditCardValidationService;

@Service
public class CreditCardValidationServiceImpl implements CreditCardValidationService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isValidCreditCard(String creditCardNumber, Date expiryDate) {
		Date currentDate = new Date();
		if ((creditCardNumber.equals("1234-1234-1234-1234")) && 
			expiryDate.after(currentDate)) {
			return true;
		}
		return false;
	}

}
