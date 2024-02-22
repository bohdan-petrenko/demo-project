package com.bp.dp.document;

import java.util.List;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("accountHistory")
public class AccountHistoryDocument {
	@Id
	private String accountId;

	/**
	 * List of money transfers ordered by creation time UTC in DESC order.
	 * Meaning last money transfer will be head (on top) of the list.
	 */
	private List<MoneyTransferNestedDocument> moneyTransfers;
}
