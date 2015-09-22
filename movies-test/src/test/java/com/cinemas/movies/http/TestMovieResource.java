package com.cinemas.movies.http;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cinemas.movies.http.HttpError;
import com.cinemas.movies.http.HttpMovie;


public class TestMovieResource {

	private static final String HTTP_HOST = "http://localhost:8080";
	private static final String URI_PATH = "movies/rest/movies";
	
	private Client client = ClientBuilder.newClient();
	private WebTarget target;
	
	@Before
	public void init(){
		target = client.target(HTTP_HOST).path(URI_PATH);
	}
	
	
	@Test
	public void testCreateMovieNoParamsXml(){					
		Response response =	target.request().accept(MediaType.APPLICATION_XML).post(Entity.entity("<movie/>", MediaType.APPLICATION_XML));
		
		verifyMissing(response);
	}
	
	@Test
	public void testCreateMovieNoParamsEntityXml(){					
		HttpMovie movieToSend = new HttpMovie();		
		Response response =	target.request().accept(MediaType.APPLICATION_XML).post(Entity.entity(movieToSend, MediaType.APPLICATION_XML));	
		verifyMissing(response);
	}
	
	@Test
	public void testCreateMovieNoParamsJson(){					
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity("{movie:{}}", MediaType.APPLICATION_JSON));
		verifyMissing(response);
	}
	
	@Test
	public void testCreateMovieNoParamsEntityJson(){					
		HttpMovie movieToSend = new HttpMovie();		
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(movieToSend, MediaType.APPLICATION_JSON));
		
		verifyMissing(response);
	}

	
	private void verifyMissing(Response response) {
		HttpError error = response.readEntity(HttpError.class);
		Assert.assertEquals(409, response.getStatus());
		Assert.assertEquals(409, error.status);
		Assert.assertEquals("MISSING_DATA", error.code);
		Assert.assertEquals("movie name is required", error.message);
		Assert.assertEquals("", error.debug);		
	}
	
	
	@Test
	public void testCreateAndGetMovie(){					
		HttpMovie movieToSend = new HttpMovie();
		movieToSend.movieName = "Movie " + new Random().nextInt(99999);
		
		movieToSend.movieGenre = "animated";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date releaseDate=null;
		try {
			releaseDate = sdf.parse("2015-07-10");
		}
		catch(ParseException ex){
			ex.printStackTrace();
		}		
		movieToSend.releaseDate = releaseDate;
		movieToSend.movieDirector = "Pierre Coffin";
		movieToSend.movieCast="Sandra Bullock,Jon Hamm,Michael Keaton";
		movieToSend.movieTrailerLink = "";
		movieToSend.ranking = 3;
				
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(movieToSend, MediaType.APPLICATION_JSON));
		
		HttpMovie createResponse = response.readEntity(HttpMovie.class);
		Assert.assertEquals(201, response.getStatus());
		Assert.assertEquals(createResponse.movieName, movieToSend.movieName);
		Assert.assertEquals(createResponse.movieGenre, movieToSend.movieGenre);
		Assert.assertNotNull(createResponse.id);
		
		//search for just created movie		
		Response search = target.queryParam("movieName", movieToSend.movieName).request().accept(MediaType.APPLICATION_JSON).get();
		List<HttpMovie> searchResponse = search.readEntity(new GenericType<List<HttpMovie>>(){});
		Assert.assertEquals(searchResponse.get(0), createResponse);		
	}


	@Test
	public void testCreateMovieExceedingFieldLength(){					
		HttpMovie movieToSend = new HttpMovie();
		movieToSend.movieName = "Movie Movie Movie Movie Movie Movie Movie Movie Movie " + new Random().nextInt(99999);
		
		movieToSend.movieGenre = "animated";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date releaseDate=null;
		try {
			releaseDate = sdf.parse("2015-07-10");
		}
		catch(ParseException ex){
			ex.printStackTrace();
		}		
		movieToSend.releaseDate = releaseDate;
		movieToSend.movieDirector = "Pierre Coffin";
		movieToSend.movieCast="Sandra Bullock,Jon Hamm,Michael Keaton";
		movieToSend.movieTrailerLink = "";
		movieToSend.ranking = 3;
				
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(movieToSend, MediaType.APPLICATION_JSON));
		
		verifyInvalidField(response);
	}

	private void verifyInvalidField(Response response) {
		HttpError error = response.readEntity(HttpError.class);
		Assert.assertEquals(409, response.getStatus());
		Assert.assertEquals(409, error.status);
		Assert.assertEquals("INVALID_FIELD", error.code);
		Assert.assertEquals("movie name length exceeded than 45 characters", error.message);
		Assert.assertEquals("", error.debug);		
	}
}
