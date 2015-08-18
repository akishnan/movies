package com.cinemas.movies.entity.impl;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.cinemas.movies.entity.User;

public class UserImpl implements User {
	
	private long id;
	private String userName;
	private String userPassword;
	private Character gender;
	private int location;
	private int favoriteTheatreId;
	private Date birthDay;
	private String creditCardNumber;
	private Date creditCardExpiryDate;
	
	public UserImpl(long id) {
		
		// TODO SUBSTITUTE by database call , hardcoding for now
		this.id = 1;
		this.userName = "foo";
		this.userPassword = "foo";
		this.gender = 'M';
		this.location = 95050;
		this.favoriteTheatreId = 1;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			birthDay = sdf.parse("2010-01-01");
		}
		catch(ParseException ex){
			ex.printStackTrace();
		}		
		this.creditCardNumber = "1234-1234-1234-1234";
		try {
			creditCardExpiryDate = sdf.parse("2018-12-31");
		}
		catch(ParseException ex){
			ex.printStackTrace();
		}				
		
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public String getUserPassword() {
		// TODO Auto-generated method stub
		return userPassword;
	}

	@Override
	public Character getGender() {
		// TODO Auto-generated method stub
		return gender;
	}

	@Override
	public int getLocation() {
		// TODO Auto-generated method stub
		return location;
	}

	@Override
	public int getFavoriteTheatreId() {
		// TODO Auto-generated method stub
		return favoriteTheatreId;
	}

	@Override
	public Date getBirthday() {
		// TODO Auto-generated method stub
		return birthDay;
	}

	@Override
	public String getCreditCardNumber() {
		// TODO Auto-generated method stub
		return creditCardNumber;
	}

	@Override
	public Date getCreditCardExpiryDate() {
		return creditCardExpiryDate;
	}
}
