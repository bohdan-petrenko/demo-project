package com.bp.dp.api.model.specific;


import com.bp.dp.api.validation.UserLogin;
import com.bp.dp.api.validation.UserPassword;

public record LogInRequest(
		@UserLogin
		String login,
		@UserPassword
		String password
) {
}
