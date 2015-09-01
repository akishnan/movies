package com.cinemas.movies.entity.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cinemas.movies.entity.Movie;
import com.cinemas.movies.entity.impl.MovieImpl;
import com.cinemas.movies.entity.impl.TheaterImpl;
import com.cinemas.movies.entity.ShowTime;
import com.cinemas.movies.entity.Theater;

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

@Entity
@Table(name="showtimes")
public class ShowTimeImpl implements ShowTime {
	
	@Id
	@Column(name="idShowTimes")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity=MovieImpl.class)
	@JoinColumn(name="Movies_idmovies")
	private Movie movie;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity=TheaterImpl.class)
	@JoinColumn(name="Theaters_idtheater")
	private Theater theater;	
		
	@Column(name="screenId")
	private long screenId;
	
	@Column(name="showTime")
	private Date showTime;
	
	@Column(name="is3D")
	private int is3D;
	
	@Column(name="theaterScreenCapacity")
	private long theaterScreenCapacity;
	
	@Column(name="ticketsRemaining")
	private int ticketsRemaining;
	
	@Column(name="ticketPrice")
	private int ticketPrice;

	@Override
	public long getId() {
		return id;
	}
	
	@Override
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	@Override
	public long getScreenId() {
		// TODO Auto-generated method stub
		return screenId;
	}
	
	public void setScreenId(long screenId) {
		this.screenId = screenId;
	}

	@Override
	public Date getShowTime() {
		// TODO Auto-generated method stub
		return showTime;
	}
	
	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}

	@Override
	public int is3D() {
		// TODO Auto-generated method stub
		return is3D;
	}
	
	public void set3D(int is3D) {
		this.is3D = is3D;
	}

	@Override
	public long getTheaterScreenCapacity() {
		return theaterScreenCapacity;
	}

	public void setTheaterScreenCapacity(int theaterScreenCapacity) {
		this.theaterScreenCapacity = theaterScreenCapacity;
	}

	
	@Override
	public int getTicketsRemaining() {
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
	
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
}
