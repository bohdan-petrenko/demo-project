package com.bp.dp.api.validation;

import com.bp.dp.util.PasswordUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserPasswordValidator implements ConstraintValidator<UserPassword, String> {

	@Override
	public boolean isValid(String userPassword, ConstraintValidatorContext constraintContext) {
		if (userPassword == null) {
			return false;
		}
		return PasswordUtils.isPasswordValid(userPassword);
	}
}