package com.bp.dp.exception;

import lombok.Getter;

public class EmailInvalidException extends RuntimeException {
	private static final String ERROR_TEMPLATE = "Email is invalid: %s";

	@Getter
	private final String email;

	public EmailInvalidException(String email) {
		super(String.format(ERROR_TEMPLATE, email));
		this.email = email;
	}
}
