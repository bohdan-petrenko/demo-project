package com.bp.dp.repository;

import java.util.Optional;

import com.bp.dp.document.UserDocument;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDocument, String> {
	Optional<UserDocument> findByEmail(String email);
	Optional<UserDocument> findByPhoneNumber(String phoneNumber);
}
