package com.cinemas.movies.entity.impl;

import com.cinemas.movies.entity.Theater;

public class TheaterImpl implements Theater {
	
	private long theaterId;
	private String theaterName;
	private String theaterAddrLine1;
	private String theaterAddrLine2;
	private String theaterCity;
	private String theaterState;
	private int zipCode;
	private int numberOfScreens;

	
	public TheaterImpl (String theaterName) {
		// TODO SUBSTITUTE by database call , hardcoding for now
		this.theaterId = 1;
		this.theaterName = "AMC Mercado 20";
		this.theaterAddrLine1 = "3111 Mission College Blvd";
		this.theaterAddrLine2 = "";
		this.theaterCity = "Santa Clara";
		this.theaterState = "CA";
		this.zipCode = 95054;
		this.numberOfScreens = 20;		
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return theaterId;
	}

	@Override
	public String getTheaterName() {
		// TODO Auto-generated method stub
		return theaterName;
	}

	@Override
	public String getTheaterAddrLine1() {
		// TODO Auto-generated method stub
		return theaterAddrLine1;
	}

	@Override
	public String getTheaterAddrLine2() {
		// TODO Auto-generated method stub
		return theaterAddrLine2;
	}

	@Override
	public String getTheaterCity() {
		// TODO Auto-generated method stub
		return theaterCity;
	}

	@Override
	public String getTheaterState() {
		// TODO Auto-generated method stub
		return theaterState;
	}

	@Override
	public int getTheaterZipCode() {
		// TODO Auto-generated method stub
		return zipCode;
	}

	@Override
	public int getNumberOfScreens() {
		// TODO Auto-generated method stub
		return numberOfScreens;
	}

}
