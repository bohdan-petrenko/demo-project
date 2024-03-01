package com.bp.dp.api.validation;

import com.bp.dp.util.EmailUtils;
import com.bp.dp.util.MobilePhoneUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserLoginValidator implements ConstraintValidator<UserLogin, String> {

	@Override
	public boolean isValid(String userLogin, ConstraintValidatorContext constraintContext) {
		if (userLogin == null) {
			return false;
		}
		return EmailUtils.isEmailValid(userLogin) || MobilePhoneUtils.isMobilePhoneNumberValid(userLogin);
	}
}