package com.bp.dp.api.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record UserDetails(
		String id,
		String email,
		String phoneNumber,
		String firstName,
		String lastName,
		@JsonIgnore
		String passwordHash,
		LocalDate dateOfBirth,
		List<UserBankAccount> accounts
		) {
}
