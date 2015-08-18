package com.cinemas.movies.entity.impl;

import java.util.Date;

import com.cinemas.movies.entity.Movie;

/**
 * represent an instance of movie object and its attributes
 * <b>id</b> being the unique attribute/key
 * 
 * @author Amit
 * @version 1.0
 * @since 2015-08-18
 *
 */

public class MovieImpl implements Movie 
{
	private long id;
	private String movieName;
	private String movieGenre;
	private Date releaseDate;
	private int ranking;
	private String movieDirector;
	private String movieCast;
	private String movieTrailerLink;
	
	public MovieImpl(long id) {
		this.id = id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public MovieImpl(String movieName) {
		// TODO SUBSTITUTE by database call , hardcoding for now

		
		this.movieName = movieName;
		this.id = 1;
		this.movieGenre = "action";
		this.movieDirector = "Christopher McQuarrie";
		this.movieCast = "Tom Cruise, Jeremy Renner, Simon Pegg";
		this.ranking = 1;		
	}

	
	@Override
	public long getId() {
		return id;
	}

	@Override
	public String getMovieName() {
		return movieName;
	}
	
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	@Override
	public String getMovieGenre() {
		return movieGenre;
	}
	
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	@Override
	public Date getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public int getRanking() {
		return ranking;
	}
	
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	@Override
	public String getMovieDirector() {
		return movieDirector;
	}
	
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	
	@Override
	public String getMovieCast() {
		return movieCast;
	}
	
	public void setMovieCast(String movieCast) {
		this.movieCast = movieCast;
	}
	

	@Override
	public String getMovieTrailerLink() {
		return movieTrailerLink;
	}

	public void setMovieTrailerLink(String movieTrailerLink) {
		this.movieTrailerLink = movieTrailerLink;
	}
	
	
}
