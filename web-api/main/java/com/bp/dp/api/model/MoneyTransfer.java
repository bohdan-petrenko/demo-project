package com.bp.dp.api.model;

import java.util.Currency;

public record MoneyTransfer(
		String id,
		String accountFromId,
		String accountToId,
		Currency currency,
		long amount,
		String description
) {
}
