package com.cinemas.movies.entity.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cinemas.movies.entity.ShowTime;

/**
 * represent an instance of showtime object and its attributes
 * the below 4 attributes uniquely identify/qualify a showtime
 * 
 * <b>movieId</b>
 * <b>theaterId</b>
 * <b>screenId</b>
 * <b>showTime</b>
 * 
 * @author Amit
 * @version 1.0
 * @since 2015-08-18
 *
 */
public class ShowTimeImpl implements ShowTime {
	
	private long movieId;
	private long theaterId;
	private long screenId;
	private Date showTime;
	private boolean is3D;
	private long theaterScreenCapacity;
	private int ticketsRemaining;
	private int ticketPrice;
	private String movieName;
	private String theaterName;
	
	public ShowTimeImpl(long movieId, long theaterId) {
		// TODO SUBSTITUTE by database call , hardcoding for now
		this.movieId = 1;
		this.theaterId = 1;
		this.screenId = 1;
		this.movieName = "mission impossible";
		this.theaterName = "AMC Mercado 20";
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			this.showTime = sdf.parse("2018-12-31 18:00:00");
		}
		catch(ParseException ex){
			ex.printStackTrace();
		}
		
		this.is3D = false;
		this.theaterScreenCapacity = 100;
		this.ticketsRemaining = 10;
		this.ticketPrice = 18;
	}

	@Override
	public long getMovieId() {
		// TODO Auto-generated method stub
		return movieId;
	}

	@Override
	public long getTheaterId() {
		// TODO Auto-generated method stub
		return theaterId;
	}

	@Override
	public long getScreenId() {
		// TODO Auto-generated method stub
		return screenId;
	}

	@Override
	public Date getShowTime() {
		// TODO Auto-generated method stub
		return showTime;
	}

	@Override
	public boolean is3D() {
		// TODO Auto-generated method stub
		return is3D;
	}

	@Override
	public long getTheaterScreenCapacity() {
		// TODO Auto-generated method stub
		return theaterScreenCapacity;
	}

	@Override
	public int getTicketsRemaining() {
		// TODO Auto-generated method stub
		return ticketsRemaining;
	}
	
	public void setTicketsRemaining(int ticketRemaining) {
		this.ticketsRemaining = ticketRemaining;
	}

	@Override
	public int getTicketPrice() {
		// TODO Auto-generated method stub
		return ticketPrice;
	}

	@Override
	public String getMovieName() {
		// TODO Auto-generated method stub
		return movieName;
	}

	@Override
	public String getTheaterName() {
		// TODO Auto-generated method stub
		return theaterName;
	}

}
