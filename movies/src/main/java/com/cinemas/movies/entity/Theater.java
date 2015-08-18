package com.cinemas.movies.entity;

public interface Theater {
	long getId();
	String getTheaterName();
	String getTheaterAddrLine1();
	String getTheaterAddrLine2();
	String getTheaterCity();
	String getTheaterState();
	int getTheaterZipCode();
	int getNumberOfScreens();
}
