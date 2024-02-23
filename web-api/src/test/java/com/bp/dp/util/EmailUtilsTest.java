package com.bp.dp.util;

import com.bp.dp.exception.EmailInvalidException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.bp.dp.util.EmailUtils.isEmailValid;
import static com.bp.dp.util.EmailUtils.unifiedEmail;
import static com.mongodb.assertions.Assertions.assertFalse;
import static com.mongodb.assertions.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailUtilsTest {

	@ParameterizedTest
	@ValueSource(strings = {
			"John.Dou@gmail.com",
			"  Vasyl@mail.ru  ",
			"pepper321@ukrnet.com.ua",
			"at_same-day@chain-net-1.io"
	})
	public void emailsShouldBeValid(String email) {
		assertTrue(isEmailValid(email));
	}

	@ParameterizedTest
	@ValueSource(strings = {
			"without.at.gmail.com",
			"without-top-domain@ukrnet",
			"double-period-at-domain@chain..io",
			"@without-local-part.com",
			""
	})
	public void emailsShouldBeInvalid(String email) {
		assertFalse(isEmailValid(email));
	}

	@Test
	public void emailValidationIsNullSafe() {
		assertFalse(isEmailValid(null));
	}

	@ParameterizedTest
	@ValueSource(strings = {"john.dou@gmail.com", "  John.Dou@gmail.com  "})
	public void unifiedEmailIsCorrect(String email) {
		String expected = "john.dou@gmail.com";
		assertEquals(expected, unifiedEmail(email));
	}

	@ParameterizedTest
	@ValueSource(strings = {
			"without.at.gmail.com",
			"without-top-domain@ukrnet",
			"double-period-at-domain@chain..io",
			"@without-local-part.com",
			""
	})
	public void unifiedEmailThrowsExceptionForInvalidEmails(String email) {
		assertThrows(
				EmailInvalidException.class,
				() -> unifiedEmail(email),
				"Email is invalid: " + email
		);
	}

	@Test
	public void unifiedEmailIsNullSafe() {
		assertThrows(
				EmailInvalidException.class,
				() -> unifiedEmail(null),
				"Email is invalid: null"
		);
	}
}
