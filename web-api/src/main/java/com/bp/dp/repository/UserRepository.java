package com.bp.dp.repository;

import com.bp.dp.document.UserDocument;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDocument, String> {
}
