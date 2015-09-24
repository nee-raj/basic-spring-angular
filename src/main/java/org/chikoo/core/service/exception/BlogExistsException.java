package org.chikoo.core.service.exception;

@SuppressWarnings("serial")
public class BlogExistsException extends RuntimeException {

	public BlogExistsException(Throwable cause) {
		super(cause);
	}

	public BlogExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public BlogExistsException(String message) {
		super(message);
	}

	public  BlogExistsException() {
	}

}
