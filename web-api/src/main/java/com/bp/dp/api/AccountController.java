package com.bp.dp.api;

import com.bp.dp.api.model.UserBankAccount;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//todo maybe user as a part of the path
@RestController
@RequestMapping("user/{userId}/accounts")
public class AccountController {

	@GetMapping("{accountId}")
	public UserBankAccount getAccount(@PathVariable String userId, @PathVariable String accountId) {
		return null;
	}

	@PostMapping
	public void createAccount(@PathVariable String userId, @RequestBody UserBankAccount account) {

	}

	@PutMapping
	public void updateAccount(@PathVariable String userId, @RequestBody Object account) {

	}

	@DeleteMapping("{accountId}")
	public void deleteAccount(@PathVariable String userId, @PathVariable String accountId) {

	}
}
