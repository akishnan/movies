package com.cinemas.movies.http;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cinemas.movies.entity.Movie;
import com.cinemas.movies.entity.ShowTime;
import com.cinemas.movies.entity.Theater;
import com.cinemas.movies.http.entity.HttpShowTime;
import com.cinemas.movies.service.MovieBrowsingService;
import com.cinemas.movies.service.ShowTimeService;
import com.cinemas.movies.service.TheaterListingService;

@Path("/showtimes")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class ShowTimeResource {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ShowTimeService showTimeService;
	
	@Autowired
	private MovieBrowsingService movieBrowsingService;	
	
	@Autowired
	private TheaterListingService theaterListingService;		
	
	@GET
	@Path("/")
	@Wrapped(element="showtimes")
	public List<HttpShowTime> getShowTimes(@QueryParam("movieName") String movieName, @QueryParam("theaterName") String theaterName ) {
		
		List<HttpShowTime> returnList = null;
		List<ShowTime> showTimeList= null;		
		
		boolean bDone = false;
		
		/**
		 * optional parameter movieName
		 */
		if (movieName != null) {
			Movie aMovie = movieBrowsingService.getMovieByName(movieName);
			if (aMovie != null) {
				long moveiId = aMovie.getId();
				showTimeList = showTimeService.getTheatersPlayingMovie(moveiId);
			}
			else {
				//unable to find.
				showTimeList = new ArrayList<>(0);	
			}
			bDone = true;
		}
		
		
		/**
		 * optional parameter theatername
		 */
		if (theaterName != null) {
			Theater aTheater = theaterListingService.getTheaterByName(theaterName);
			if (aTheater != null) {
				long theaterId = aTheater.getId();
				showTimeList = showTimeService.getMoviesPlayingInTheater(theaterId);
			}
			else {
				//unable to find.
				showTimeList = new ArrayList<>(0);	
			}
			bDone = true;
		}

		
		if (!bDone) {
			//default to all movies unsorted
			showTimeList = showTimeService.getAllShowTimes();
		}
		
		returnList = new ArrayList<>(showTimeList.size());
		
		for(ShowTime aShowTime:showTimeList){
			returnList.add(new HttpShowTime(aShowTime));
		}
		
		return returnList;
	}	
	
}