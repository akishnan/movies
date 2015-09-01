package com.cinemas.movies.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemas.movies.entity.Theater;
import com.cinemas.movies.repository.TheaterRepository;
import com.cinemas.movies.service.TheaterListingService;

@Service
public class TheaterListingServiceImpl implements TheaterListingService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TheaterRepository theaterRepository;
	
	@Override
	@Transactional
	public Theater addTheater(Theater aTheater) {
		long theaterId =  theaterRepository.addTheater(aTheater);
		return getTheaterId(theaterId);
	}
	
	@Override
	@Transactional
	public Theater getTheaterId(long theaterId) {
		return theaterRepository.getTheaterById(theaterId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Theater getTheaterByName(String theaterName) {
		return theaterRepository.getTheaterByName(theaterName);
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
		return theaterRepository.getTheaters();
	}
}
