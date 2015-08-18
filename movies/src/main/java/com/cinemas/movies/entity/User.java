package com.cinemas.movies.entity;

import java.util.Date;

public interface User {
	long getId();
	String getUserName();
	String getUserPassword();
	Character getGender();
	int getLocation();
	int getFavoriteTheatreId();
	Date getBirthday();
	String getCreditCardNumber();
	Date getCreditCardExpiryDate();
}