package com.bp.dp.repository;

import com.bp.dp.document.AccountHistoryDocument;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountHistoryRepository extends MongoRepository<AccountHistoryDocument, String> {
}
