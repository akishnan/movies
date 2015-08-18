package com.cinemas.movies.entity;

import java.util.Date;

public interface ShowTime {
	long getMovieId();
	long getTheaterId();
	long getScreenId();
	Date getShowTime();
	boolean is3D();
	long getTheaterScreenCapacity();
	long getTicketsRemaining();
	int getTicketPrice();
}
