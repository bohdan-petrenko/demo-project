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
@Constraint(validatedBy = UserLoginValidator.class)
@Documented
public @interface UserLogin {

	//todo try to move this to single place with localization
	String message() default "User login should be a valid email 'example@domain.com' or mobile phone number '+380000000000'";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}