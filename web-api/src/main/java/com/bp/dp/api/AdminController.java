package com.bp.dp.api;

import java.util.Optional;

import com.bp.dp.document.AccountHistoryDocument;
import com.bp.dp.document.AccountNestedDocument;
import com.bp.dp.document.UserDocument;
import com.bp.dp.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//todo remove me
@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {
	private final AdminService adminService;

	@GetMapping("user")
	public Optional<UserDocument> getUser(@RequestParam String userId) {
		return adminService.getUser(userId);
	}

	@PostMapping("user")
	public UserDocument saveUser(@RequestBody UserDocument user) {
		user.setId(null);
		for (AccountNestedDocument account : user.getAccounts()) {
			account.setId(ObjectId.get().toHexString());
		}
		return adminService.createUser(user);
	}

	@GetMapping("account-history")
	public Optional<AccountHistoryDocument> getAccountHistory(@RequestParam String accountId) {
		return adminService.getAccountHistory(accountId);
	}

	@PostMapping("account-history")
	public AccountHistoryDocument saveAccountHistory(@RequestBody AccountHistoryDocument accountHistory) {
		return adminService.createAccountHistory(accountHistory);
	}
}
