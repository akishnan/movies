package com.cinemas.movies.http;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HttpMovie other = (HttpMovie) obj;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}	
}