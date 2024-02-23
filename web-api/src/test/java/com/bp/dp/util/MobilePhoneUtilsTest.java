package com.bp.dp.util;

import com.bp.dp.exception.MobilePhoneNumberInvalidException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.bp.dp.util.MobilePhoneUtils.isMobilePhoneNumberValid;
import static com.bp.dp.util.MobilePhoneUtils.unifiedMobilePhoneNumber;
import static com.mongodb.assertions.Assertions.assertFalse;
import static com.mongodb.assertions.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MobilePhoneUtilsTest {

	@ParameterizedTest
	@ValueSource(strings = {"+380987654321", "0987654321"})
	public void phoneNumbersShouldBeValid(String phoneNumber) {
		assertTrue(isMobilePhoneNumberValid(phoneNumber));
	}

	@ParameterizedTest
	@ValueSource(strings = {"380987654321", "80987654321", "987654321", ""})
	public void phoneNumbersShouldBeInvalid(String phoneNumber) {
		assertFalse(isMobilePhoneNumberValid(phoneNumber));
	}

	@Test
	public void phoneNumberValidationIsNullSafe() {
		assertFalse(isMobilePhoneNumberValid(null));
	}

	@ParameterizedTest
	@ValueSource(strings = {"+380987654321", "0987654321"})
	public void unifiedPhoneNumberIsCorrect(String phoneNumber) {
		String expected = "+380987654321";
		assertEquals(expected, unifiedMobilePhoneNumber(phoneNumber));
	}

	@ParameterizedTest
	@ValueSource(strings = {"380987654321", "80987654321", "987654321", ""})
	public void unifiedPhoneNumberThrowsExceptionForInvalidNumbers(String phoneNumber) {
		assertThrows(
				MobilePhoneNumberInvalidException.class,
				() -> unifiedMobilePhoneNumber(phoneNumber),
				"Mobile phone number is invalid: " + phoneNumber
		);
	}

	@Test
	public void unifiedPhoneNumberIsNullSafe() {
		assertThrows(
				MobilePhoneNumberInvalidException.class,
				() -> unifiedMobilePhoneNumber(null),
				"Mobile phone number is invalid: null"
		);
	}
}
