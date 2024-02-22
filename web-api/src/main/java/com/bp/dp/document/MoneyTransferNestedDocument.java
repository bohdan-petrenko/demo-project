package com.bp.dp.document;

import lombok.Data;

//todo think no need to store in or out money type. It can be calculated on service layer, comparing senderUserId
//todo think how to link data about sender or receiver. To display first & last names
@Data
public class MoneyTransferNestedDocument {
	private String id;
	private long amount;
	private String currency;
	private String description;
	private long creationTimeMillisUtc;
	private String senderUserId;
	private String senderAccountId;
	private String receiverUserId;
	private String receiverAccountId;
}
