package com.cinemas.movies.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cinemas.movies.entity.Theater;
import com.cinemas.movies.repository.TheaterRepository;
import com.cinemas.movies.service.TheaterListingService;
import com.cinemas.movies.service.exception.InvalidFieldException;
import com.cinemas.movies.service.exception.MissingDataException;

@Service
public class TheaterListingServiceImpl implements TheaterListingService {
	
	private static final int MAX_THEATER_NAME_LENGTH = 45;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TheaterRepository theaterRepository;
	
	@Override
	@Transactional
	public Theater addTheater(Theater aTheater) {
		if(StringUtils.isEmpty(aTheater.getTheaterName())){			
			throw new MissingDataException("theater name is required");
		}	
		
		if (aTheater.getTheaterName().length() > MAX_THEATER_NAME_LENGTH) {
			throw new InvalidFieldException("theater name length exceeded than 45 characters");
		}
		
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
	@Transactional
	public List<Theater> getAllTheaters() {
		//TODO load theaters from database
		return theaterRepository.getTheaters();
	}
}
