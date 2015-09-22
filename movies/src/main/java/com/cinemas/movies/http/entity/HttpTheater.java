package com.cinemas.movies.http.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.cinemas.movies.entity.Theater;

@XmlRootElement(name = "theater")
public class HttpTheater {

	@XmlElement
	public long id;
	
	@XmlElement
	public String theaterName;
	
	@XmlElement
	public String theaterAddrLine1;
	
	@XmlElement
	public String theaterAddrLine2;
	
	@XmlElement
	public String theaterCity;
	
	@XmlElement	
	public String theaterState;
	
	@XmlElement
	public int theaterZipCode;
	
	@XmlElement
	public int theaterNumOfScreens;
	
	//required by framework
	protected HttpTheater() {}

	public HttpTheater(Theater aTheater) {
		if (aTheater != null) {
			this.id=aTheater.getId();
			this.theaterName = aTheater.getTheaterName();
			this.theaterAddrLine1 = aTheater.getTheaterAddrLine1();
			this.theaterAddrLine2 = aTheater.getTheaterAddrLine2();
			this.theaterCity = aTheater.getTheaterCity();
			this.theaterZipCode = aTheater.getTheaterZipCode();
			this.theaterNumOfScreens = aTheater.getNumberOfScreens();			
		}
	}
}
