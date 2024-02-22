package com.bp.dp.document;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("users")
public class UserDocument {
	@Id
	private String id;
	//todo add indexing
	private String email;
	//todo add indexing
	private String phoneNumber;
	private String firstName;
	private String lastName;
	private long dateOfBirthMillisUtc;
	private String passwordHash;
	private List<AccountNestedDocument> accounts;
}
