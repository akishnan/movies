package com.cinemas.movies.entity;

import java.util.Date;

public interface Movie {
	long getId();	
	String getMovieName();
	String getMovieGenre();
	Date getReleaseDate();
	int getRanking();
	String getMovieDirector();
	String getMovieCast();
	String getMovieTrailerLink();
}
