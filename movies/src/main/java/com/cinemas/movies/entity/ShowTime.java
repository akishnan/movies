package com.cinemas.movies.entity;

import java.util.Date;

public interface ShowTime {
	long getId();
	Movie getMovie();
	Theater getTheater();
	long getScreenId();
	Date getShowTime();
	int is3D();
	long getTheaterScreenCapacity();
	int getTicketsRemaining();
	int getTicketPrice();

}
