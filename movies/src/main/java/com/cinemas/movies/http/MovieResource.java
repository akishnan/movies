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
import org.springframework.util.StringUtils;

import com.cinemas.movies.http.entity.HttpMovie;
import com.cinemas.movies.service.MovieBrowsingService;
import com.cinemas.movies.service.exception.MoviesException;
import  com.cinemas.movies.entity.Movie;
import com.cinemas.movies.entity.impl.MovieImpl;


@Path("/movies")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class MovieResource {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MovieBrowsingService movieBrowsingService;
	
	@GET
	@Path("/")
	@Wrapped(element="movies")
	public List<HttpMovie> getMovies(@QueryParam("orderBy") String orderBy, @QueryParam("movieName") String movieName) {
		
		List<HttpMovie> returnList = null;
		List<Movie> movieList= null;		
		
		boolean bDone = false;
		
		/**
		 * optional parameter movieName
		 */
		if (movieName != null) {
			logger.info("movies search movieName="+movieName);
			Movie aMovie = movieBrowsingService.getMovieByName(movieName);		
			if (aMovie != null) {
				movieList = new ArrayList<>(1);
				movieList.add(aMovie);
			} else {
				//unable to find.
				movieList = new ArrayList<>(0);				
			}
			bDone = true;
		}
		
		/**
		 * optional orderby parameters (e.g. releaseDate or ranking)
		 */
		if (!bDone) {
			if (orderBy != null) {
				if (orderBy.compareToIgnoreCase("releaseDate") == 0) {
					movieList = movieBrowsingService.sortMoviesByReleaseDate();
					bDone = true;
				}
				else if (orderBy.compareToIgnoreCase("ranking") == 0) {
					movieList = movieBrowsingService.sortMoviesByRanking();
					bDone = true;
				}
			}
		}
	
		if (!bDone) {
			//default to all movies unsorted
			movieList = movieBrowsingService.getMovies();
		}
		
		returnList = new ArrayList<>(movieList.size());
		
		for(Movie aMovie:movieList){
			returnList.add(new HttpMovie(aMovie));
		}
		
		return returnList;
	}	
	
	
	@GET
	@Path("/{movieId}")	
	public HttpMovie getMovieById(@PathParam("movieId") long movieId){
		logger.info("getting movie by id:"+movieId);
		Movie aMovie = movieBrowsingService.getMovieById(movieId);	
		return new HttpMovie(aMovie);
	}
	
	
	@POST
	@Path("/")
	public Response createMovie(HttpMovie newMovie){
		Movie movieToCreate = convert(newMovie);
		Movie addedMovie = movieBrowsingService.addMovie(movieToCreate);
		return Response.status(Status.CREATED).header("Location", "/movies/"+addedMovie.getId()).entity(new HttpMovie(addedMovie)).build();
	}		
	
	/**
	 * Not pushing this into business layer. Could be a util as well
	 * @param newUser
	 * @return
	 */
	private Movie convert(HttpMovie httpMovie) {
		MovieImpl aMovie = new MovieImpl();
		aMovie.setMovieName(httpMovie.movieName);
		aMovie.setMovieGenre(httpMovie.movieGenre);
		aMovie.setMovieDirector(httpMovie.movieDirector);
		aMovie.setMovieCast(httpMovie.movieCast);
		aMovie.setMovieTrailerLink(httpMovie.movieTrailerLink);
		aMovie.setRanking(httpMovie.ranking);
		aMovie.setReleaseDate(httpMovie.releaseDate);
		return aMovie;
	}	
	
	
}
