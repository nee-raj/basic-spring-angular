package org.chikoo.core.service.exception;

@SuppressWarnings("serial")
public class AccountExistsException extends RuntimeException {

	public AccountExistsException(Throwable cause) {
		super(cause);
	}

	public AccountExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccountExistsException(String message) {
		super(message);
	}

	public AccountExistsException() {
	}

}
