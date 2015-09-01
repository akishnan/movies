package com.cinemas.movies.entity.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cinemas.movies.entity.Theater;

/**
 * represent an instance of theater object and its attributes
 * <b>id</b> being the unique attribute/key
 * 
 * @author Amit
 * @version 1.0
 * @since 2015-08-18
 *
 */

@Entity
@Table(name="theaters")
public class TheaterImpl implements Theater {
	
	@Id
	@Column(name="idtheater")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="theaterName")
	private String theaterName;
	
	@Column(name="theaterAddrLine1")
	private String theaterAddrLine1;
	
	@Column(name="theaterAddrLine2")
	private String theaterAddrLine2;
	
	@Column(name="theaterCity")
	private String theaterCity;
	
	@Column(name="theaterState")	
	private String theaterState;
	
	@Column(name="theaterZipCode")
	private int theaterZipCode;
	
	@Column(name="theaterNumOfScreens")
	private int theaterNumOfScreens;

	
	public TheaterImpl () {
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String getTheaterName() {
		return theaterName;
	}
	
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	

	@Override
	public String getTheaterAddrLine1() {
		// TODO Auto-generated method stub
		return theaterAddrLine1;
	}
	
	public void setTheaterAddrLine1(String theaterAddrLine1) {
		this.theaterAddrLine1 = theaterAddrLine1;
	}

	@Override
	public String getTheaterAddrLine2() {
		// TODO Auto-generated method stub
		return theaterAddrLine2;
	}
	
	public void setTheaterAddrLine2(String theaterAddrLine2) {
		this.theaterAddrLine2 = theaterAddrLine2;
	}

	@Override
	public String getTheaterCity() {
		// TODO Auto-generated method stub
		return theaterCity;
	}
	
	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}

	@Override
	public String getTheaterState() {
		// TODO Auto-generated method stub
		return theaterState;
	}
	
	public void setTheaterState(String theaterState) {
		this.theaterState = theaterState;
	}

	@Override
	public int getTheaterZipCode() {
		// TODO Auto-generated method stub
		return theaterZipCode;
	}
	
	public void setTheaterZipCode(int theaterZipCode) {
		this.theaterZipCode = theaterZipCode;
	}

	@Override
	public int getNumberOfScreens() {
		// TODO Auto-generated method stub
		return theaterNumOfScreens;
	}
	
	public void setNumberOfScreens(int theaterNumOfScreens) {
		this.theaterNumOfScreens = theaterNumOfScreens;
	}

}
