package com.bp.dp.api.model;

import java.util.Optional;

//todo Create predefined каса відділення банку & термінал
public record UserBankAccount(
		String id,
		Currency currency,
		//todo add converter for string representation
		long balance,
		Optional<String> description
) {
}
