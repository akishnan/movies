package com.cinemas.movies.service.exception;

public class MissingDataException extends MoviesException {

	public MissingDataException(String message, Throwable throwable) {
		super(ErrorCode.MISSING_DATA, message, throwable);
	}
	
	public MissingDataException(String message) {
		super(ErrorCode.MISSING_DATA, message);
	}

}
