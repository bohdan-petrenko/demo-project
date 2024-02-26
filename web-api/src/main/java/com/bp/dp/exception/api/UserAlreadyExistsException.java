package com.bp.dp.exception.api;

import com.bp.dp.document.UserDocument;
import lombok.Getter;

@Getter
public class UserAlreadyExistsException extends RuntimeException {
	private static final String ERROR_TEMPLATE = "User already exists: %s";
	private final UserDocument userDocument;

	public UserAlreadyExistsException(UserDocument userDocument) {
		super(String.format(ERROR_TEMPLATE, userDocument));
		this.userDocument = userDocument;
	}
}
