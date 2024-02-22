package com.bp.dp.api.model;

import java.time.LocalDate;

public record UserDetails(
		long id,
		String firstName,
		String lastName,
		LocalDate dateOfBirth
		) {
}
