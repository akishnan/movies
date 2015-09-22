package com.cinemas.movies.http;

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

public class TestTheaterResource {

	private static final String HTTP_HOST = "http://localhost:8080";
	private static final String URI_PATH = "movies/rest/theaters";
	
	private Client client = ClientBuilder.newClient();
	private WebTarget target;
	
	@Before
	public void init(){
		target = client.target(HTTP_HOST).path(URI_PATH);
	}
	
	@Test
	public void testCreateTheaterNoParamsXml(){					
		Response response =	target.request().accept(MediaType.APPLICATION_XML).post(Entity.entity("<theater/>", MediaType.APPLICATION_XML));
		
		verifyMissing(response);
	}
	
	@Test
	public void testCreateTheaterNoParamsEntityXml(){					
		HttpTheater theaterToSend = new HttpTheater();		
		Response response =	target.request().accept(MediaType.APPLICATION_XML).post(Entity.entity(theaterToSend, MediaType.APPLICATION_XML));	
		verifyMissing(response);
	}
	
	@Test
	public void testCreateTheaterNoParamsJson(){					
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity("{theater:{}}", MediaType.APPLICATION_JSON));
		verifyMissing(response);
	}
	
	@Test
	public void testCreateTheaterNoParamsEntityJson(){					
		HttpTheater theaterToSend = new HttpTheater();		
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(theaterToSend, MediaType.APPLICATION_JSON));
		
		verifyMissing(response);
	}

	
	private void verifyMissing(Response response) {
		HttpError error = response.readEntity(HttpError.class);
		Assert.assertEquals(409, response.getStatus());
		Assert.assertEquals(409, error.status);
		Assert.assertEquals("MISSING_DATA", error.code);
		Assert.assertEquals("theater name is required", error.message);
		Assert.assertEquals("", error.debug);		
	}	
	
	
	@Test
	public void testCreateAndGetTheater(){		
		HttpTheater theaterToSend = new HttpTheater();
		theaterToSend.theaterName = "Theater " + new Random().nextInt(99999);
		theaterToSend.theaterAddrLine1="825 Middlefield Rd";
		theaterToSend.theaterAddrLine2="";
		theaterToSend.theaterCity="Redwood City";
		theaterToSend.theaterState="CA";
		theaterToSend.theaterZipCode=94063;
		theaterToSend.theaterNumOfScreens=5;
		
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(theaterToSend, MediaType.APPLICATION_JSON));
				
		HttpTheater createResponse = response.readEntity(HttpTheater.class);
		Assert.assertEquals(201, response.getStatus());
		Assert.assertEquals(createResponse.theaterName, theaterToSend.theaterName);
		Assert.assertEquals(createResponse.theaterAddrLine1, theaterToSend.theaterAddrLine1);
		Assert.assertNotNull(createResponse.id);
		
		//search for just created theater		
		Response search = target.queryParam("theaterName", theaterToSend.theaterName).request().accept(MediaType.APPLICATION_JSON).get();
		List<HttpTheater> searchResponse = search.readEntity(new GenericType<List<HttpTheater>>(){});
		Assert.assertEquals(searchResponse.get(0), createResponse);		
	}
	
	
	@Test
	public void testCreateTheaterExceedingFieldLength(){		
		HttpTheater theaterToSend = new HttpTheater();
		theaterToSend.theaterName = "Theater Theater Theater Theater Theater Theater Theater Theater Theater " + new Random().nextInt(99999);
		theaterToSend.theaterAddrLine1="825 Middlefield Rd";
		theaterToSend.theaterAddrLine2="";
		theaterToSend.theaterCity="Redwood City";
		theaterToSend.theaterState="CA";
		theaterToSend.theaterZipCode=94063;
		theaterToSend.theaterNumOfScreens=5;
		
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(theaterToSend, MediaType.APPLICATION_JSON));
		
		verifyInvalidField(response);
	}
	
	private void verifyInvalidField(Response response) {
		HttpError error = response.readEntity(HttpError.class);
		Assert.assertEquals(409, response.getStatus());
		Assert.assertEquals(409, error.status);
		Assert.assertEquals("INVALID_FIELD", error.code);
		Assert.assertEquals("theater name length exceeded than 45 characters", error.message);
		Assert.assertEquals("", error.debug);		
	}

}
