package com.bp.dp.service;

import java.util.Optional;

import com.bp.dp.document.AccountHistoryDocument;
import com.bp.dp.document.UserDocument;
import com.bp.dp.repository.AccountHistoryRepository;
import com.bp.dp.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

//todo remove me
@Service
@RequiredArgsConstructor
public class AdminService {
	private final UserRepository userRepository;
	private final AccountHistoryRepository accountHistoryRepository;

	public Optional<UserDocument> getUser(String userId) {
		return userRepository.findById(userId);
	}

	public UserDocument createUser(UserDocument user) {
		return userRepository.save(user);
	}

	public Optional<AccountHistoryDocument> getAccountHistory(String accountId) {
		return accountHistoryRepository.findById(accountId);
	}

	public AccountHistoryDocument createAccountHistory(AccountHistoryDocument accountHistory) {
		return accountHistoryRepository.save(accountHistory);
	}
}
