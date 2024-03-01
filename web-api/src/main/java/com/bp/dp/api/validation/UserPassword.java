package com.bp.dp.api.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserPasswordValidator.class)
@Documented
public @interface UserPassword {

	//todo try to move this to single place with localization
	String message() default "User password should contain at least one upper case one lower case letters and one number. Allowed password length from 6 to 16 symbols";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}