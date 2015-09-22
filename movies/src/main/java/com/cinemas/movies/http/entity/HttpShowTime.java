package com.cinemas.movies.http.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.cinemas.movies.entity.Movie;
import com.cinemas.movies.entity.ShowTime;
import com.cinemas.movies.entity.Theater;
import com.cinemas.movies.entity.impl.MovieImpl;
import com.cinemas.movies.entity.impl.TheaterImpl;

@XmlRootElement(name = "showtime")
public class HttpShowTime {

	@XmlElement
	public long id;
	
	@XmlElement(type=MovieImpl.class)
	public Movie movie;
	
	@XmlElement(type=TheaterImpl.class)
	public Theater theater;	
		
	@XmlElement
	public long screenId;
	
	@XmlElement
	public Date showTime;
	
	@XmlElement
	public int is3D;
	
	@XmlElement
	public long theaterScreenCapacity;
	
	@XmlElement
	public int ticketsRemaining;
	
	@XmlElement
	public int ticketPrice;
	
	//required by framework
	protected HttpShowTime() {}

	public HttpShowTime(ShowTime aShowTime) {
		if (aShowTime != null) {
			this.id = aShowTime.getId();
			this.movie = aShowTime.getMovie();
			this.theater = aShowTime.getTheater();
			this.screenId = aShowTime.getScreenId();
			this.showTime = aShowTime.getShowTime();
			this.is3D = aShowTime.is3D();
			this.theaterScreenCapacity = aShowTime.getTheaterScreenCapacity();
			this.ticketsRemaining = aShowTime.getTicketsRemaining();
			this.ticketPrice = aShowTime.getTicketPrice();
		}
	}
}