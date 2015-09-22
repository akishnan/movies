package com.cinemas.movies.http;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cinemas.movies.entity.Theater;
import com.cinemas.movies.entity.impl.TheaterImpl;
import com.cinemas.movies.http.entity.HttpTheater;
import com.cinemas.movies.service.TheaterListingService;

@Path("/theaters")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class TheaterResource {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TheaterListingService theaterListingService;

	
	@GET
	@Path("/")
	@Wrapped(element="theaters")
	public List<HttpTheater> getTheaters(@QueryParam("theaterName") String theaterName) {
		
		List<HttpTheater> returnList = null;
		List<Theater> theaterList= null;		
		
		boolean bDone = false;
		
		/**
		 * optional parameter theatername
		 */
		if (theaterName != null) {
			logger.info("search theaterName="+theaterName);
			Theater aTheater = theaterListingService.getTheaterByName(theaterName);	
			if (aTheater != null) {
				theaterList = new ArrayList<>(1);
				theaterList.add(aTheater);
			} else {
				//unable to find.
				theaterList = new ArrayList<>(0);				
			}
			bDone = true;
		}
	
		if (!bDone) {
			//default to all theaters
			theaterList = theaterListingService.getAllTheaters();
		}
		
		returnList = new ArrayList<>(theaterList.size());
		
		for(Theater aTheater:theaterList){
			returnList.add(new HttpTheater(aTheater));
		}
		
		return returnList;
	}	
	
	@GET
	@Path("/{theaterId}")	
	public HttpTheater getTheaterById(@PathParam("theaterId") long theaterId){
		logger.info("getting theaterId by id:"+theaterId);
		Theater aTheater = theaterListingService.getTheaterId(theaterId);	
		return new HttpTheater(aTheater);
	}
	
	@POST
	@Path("/")
	public Response createTheater(HttpTheater newTheater){
		Theater theaterToCreate = convert(newTheater);
		Theater addedTheater = theaterListingService.addTheater(theaterToCreate);
		return Response.status(Status.CREATED).header("Location", "/theaters/"+addedTheater.getId()).entity(new HttpTheater(addedTheater)).build();
	}		
	
	/**
	 * Not pushing this into business layer. Could be a util as well
	 * @param newUser
	 * @return
	 */
	private Theater convert(HttpTheater httpTheater) {
		TheaterImpl aTheater = new TheaterImpl();
		aTheater.setTheaterName(httpTheater.theaterName);
		aTheater.setTheaterAddrLine1(httpTheater.theaterAddrLine1);
		aTheater.setTheaterAddrLine2(httpTheater.theaterAddrLine2);
		aTheater.setTheaterCity(httpTheater.theaterCity);
		aTheater.setTheaterState(httpTheater.theaterState);
		aTheater.setTheaterZipCode(httpTheater.theaterZipCode);
		aTheater.setNumberOfScreens(httpTheater.theaterNumOfScreens);
		return aTheater;
	}		
}
