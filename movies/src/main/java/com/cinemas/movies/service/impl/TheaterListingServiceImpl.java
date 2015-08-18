package com.cinemas.movies.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinemas.movies.entity.Theater;
import com.cinemas.movies.entity.impl.TheaterImpl;
import com.cinemas.movies.service.TheaterListingService;

@Service
public class TheaterListingServiceImpl implements TheaterListingService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Theater getTheaterByName(String theaterName) {
		return new TheaterImpl(theaterName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Theater getTheaterByZipCode(int zipCode) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Theater> getAllTheaters() {
		//TODO load theaters from database
		return null;
	}

}
