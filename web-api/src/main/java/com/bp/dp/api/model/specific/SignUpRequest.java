package com.bp.dp.api.model.specific;

import java.time.LocalDate;

public record SignUpRequest(
		String email,
		String phoneNumber,
		String firstName,
		String lastName,
		LocalDate dateOfBirth,
		String password
) {
}
