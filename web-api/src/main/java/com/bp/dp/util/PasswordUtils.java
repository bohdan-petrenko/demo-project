package com.bp.dp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bp.dp.exception.MobilePhoneNumberInvalidException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PasswordUtils {
	private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?!.* ).{6,16}$");

	public static boolean isPasswordValid(String password) {
		if (password == null) {
			return false;
		}
		Matcher matcher = PASSWORD_PATTERN.matcher(password);
		return matcher.find();
	}
}
