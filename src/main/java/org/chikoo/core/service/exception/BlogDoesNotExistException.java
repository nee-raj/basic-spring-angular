package org.chikoo.core.service.exception;

@SuppressWarnings("serial")
public class BlogDoesNotExistException extends RuntimeException {

	public BlogDoesNotExistException(Throwable cause) {
		super(cause);
	}

	public BlogDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public BlogDoesNotExistException(String message) {
		super(message);
	}

	public  BlogDoesNotExistException() {
		
	}

}
