package com.cinemas.movies.http.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.cinemas.movies.service.exception.MoviesException;

/**
 * Return HTTP 409 with response body 
 * 
 * @author Amit
 *
 */
@Provider
@Component
public class MovieExceptionMapper implements ExceptionMapper<MoviesException> {

	@Override
	public Response toResponse(MoviesException ex) {
		return Response.status(Status.CONFLICT).entity(new HttpError(ex)).build();
	}
}
