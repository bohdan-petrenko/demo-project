package com.bp.dp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bp.dp.exception.MobilePhoneNumberInvalidException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MobilePhoneUtils {
	private static final String MOBILE_PHONE_PREFIX = "+38";

	private static final Pattern MOBILE_PHONE_PATTERN = Pattern.compile("^(\\+38)?\\d{10}$");

	private static final int UNIFIED_MOBILE_PHONE_NUMBER_LENGTH = 13;

	public static boolean isMobilePhoneNumberValid(String mobilePhone) {
		if (mobilePhone == null) {
			return false;
		}
		Matcher matcher = MOBILE_PHONE_PATTERN.matcher(mobilePhone);
		return matcher.find();
	}

	public static String unifiedMobilePhoneNumber(String validPhoneNumber) throws MobilePhoneNumberInvalidException {
		if (!isMobilePhoneNumberValid((validPhoneNumber))) {
			throw new MobilePhoneNumberInvalidException(validPhoneNumber);
		}
		return validPhoneNumber.length() == UNIFIED_MOBILE_PHONE_NUMBER_LENGTH
				? validPhoneNumber
				: MOBILE_PHONE_PREFIX + validPhoneNumber;
	}
}
