package com.cinemas.movies.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.cinemas.movies.entity.Movie;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestCreditCardValidationService extends AbstractJUnit4SpringContextTests  {
	@Autowired
	private CreditCardValidationService creditCardValidationService;

	@Test
	public void testCreditCardValidation(){		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date toTestExpiryDate1=null;
		Date toTestExpiryDate2=null;
		
		try {
			toTestExpiryDate1 = sdf.parse("2015-12-31 18:00:00");
			toTestExpiryDate2 = sdf.parse("2014-12-31 18:00:00");
		}
		catch(ParseException ex){
			ex.printStackTrace();
		}
		Assert.assertEquals(true, creditCardValidationService.isValidCreditCard("1234-1234-1234-1234", toTestExpiryDate1));
		
		//mismatch in the credit card number
		Assert.assertEquals(false, creditCardValidationService.isValidCreditCard("3452-2345-1243-1234", toTestExpiryDate1));
		
		//toTestExpiryDate2 date is before the current date - test should return false
		Assert.assertEquals(false, creditCardValidationService.isValidCreditCard("1234-1234-1234-1234", toTestExpiryDate2));
		
	}
}