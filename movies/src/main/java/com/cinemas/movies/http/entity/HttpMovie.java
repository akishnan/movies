package com.cinemas.movies.http.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.cinemas.movies.entity.Movie;

@XmlRootElement(name = "movie")
public class HttpMovie {
	
	@XmlElement
	public long id;
	
	@XmlElement
	public String movieName;
	
	@XmlElement	
	public String movieGenre;
	
	@XmlElement
	public Date releaseDate;

	@XmlElement
	public int ranking;
	
	@XmlElement
	public String movieDirector;

	@XmlElement
	public String movieCast;
	
	@XmlElement
	public String movieTrailerLink;
		
	//required by framework
	protected HttpMovie() {}

	public HttpMovie(Movie aMovie) {
		this.id=aMovie.getId();
		this.movieName = aMovie.getMovieName();
		this.movieGenre = aMovie.getMovieGenre();
		this.releaseDate = aMovie.getReleaseDate();
		this.ranking = aMovie.getRanking();
		this.movieDirector = aMovie.getMovieDirector();
		this.movieCast = aMovie.getMovieCast();
		this.movieTrailerLink = aMovie.getMovieTrailerLink();
	}

	
}
