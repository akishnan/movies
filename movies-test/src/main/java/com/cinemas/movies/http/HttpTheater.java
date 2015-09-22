package com.cinemas.movies.http;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HttpTheater other = (HttpTheater) obj;
		if (theaterName == null) {
			if (other.theaterName != null)
				return false;
		} else if (!theaterName.equals(other.theaterName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}		
}
