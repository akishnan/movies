package com.cinemas.movies.entity.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

@Entity
@Table(name="movies")
public class MovieImpl implements Movie 
{
	@Id
	@Column(name="idmovies")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="movieName")
	private String movieName;
	
	@Column(name="movieGenre")
	private String movieGenre;
	
	@Column(name="releaseDate")
	private Date releaseDate;
	
	@Column(name="ranking")
	private int ranking;
	
	@Column(name="movieDirector")
	private String movieDirector;
	
	@Column(name="movieCast")
	private String movieCast;
	
	@Column(name="movieTrailerLink")
	private String movieTrailerLink;
	

	public MovieImpl() {}
	
	@Override
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
