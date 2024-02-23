package com.bp.dp.exception;

import lombok.Getter;

public class MobilePhoneNumberInvalidException extends RuntimeException {
	private static final String ERROR_TEMPLATE = "Mobile phone number is invalid: %s";

	@Getter
	private final String mobilePhoneNumber;

	public MobilePhoneNumberInvalidException(String mobilePhoneNumber) {
		super(String.format(ERROR_TEMPLATE, mobilePhoneNumber));
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
}
