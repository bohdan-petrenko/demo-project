package com.bp.dp.document;

import com.mongodb.lang.Nullable;
import lombok.Data;

@Data
public class AccountNestedDocument {
	private String id;
	private @Nullable String description;
	private long balance;
	private String currency;
}
