package org.chikoo.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
	public BadRequestException(Throwable cause) {
		super(cause);
	}
	
	public BadRequestException() {
	}
}
