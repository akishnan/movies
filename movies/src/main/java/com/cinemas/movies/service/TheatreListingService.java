package com.cinemas.movies.service;

import com.cinemas.movies.entity.Theater;

public interface TheatreListingService {

	Theater getTheatreByName(String theaterName);
}
