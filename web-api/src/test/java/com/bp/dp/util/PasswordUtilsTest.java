package com.bp.dp.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.bp.dp.util.PasswordUtils.isPasswordValid;
import static com.mongodb.assertions.Assertions.assertFalse;
import static com.mongodb.assertions.Assertions.assertTrue;

class PasswordUtilsTest {
	@ParameterizedTest
	@ValueSource(strings = {"MinSz6", "16IsMaxSizeOfPas", "Ll1!@#$%^&*()"})
	public void passwordShouldBeValid(String password) {
		assertTrue(isPasswordValid(password));
	}

	@ParameterizedTest
	@ValueSource(strings = {
			"",
			"Tiny1",
			"TooLong1234567890",
			"lowercase1",
			"UPPERCASE1",
			"WithoutNumber",
			"1234567890",
			" TrimMe1 ",
			"Space 1"
	})
	public void passwordShouldBeInvalid(String password) {
		assertFalse(isPasswordValid(password));
	}

	@Test
	public void passwordValidationIsNullSafe() {
		assertFalse(isPasswordValid(null));
	}
}