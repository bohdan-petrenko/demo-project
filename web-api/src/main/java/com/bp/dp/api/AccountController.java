package com.bp.dp.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//todo maybe user as a part of the path
@RestController("user/{userId}/accounts")
public class AccountController {

	@GetMapping
	public void getAllAccountsForUser(@PathVariable String userId) {

	}

	@GetMapping("{accountId}")
	public void getAccount(@PathVariable String userId, @PathVariable String accountId) {

	}

	@PostMapping
	public void createAccount(@PathVariable String userId, @RequestBody Object account) {

	}

	@PutMapping
	public void updateAccount(@PathVariable String userId, @RequestBody Object account) {

	}

	@DeleteMapping("{accountId}")
	public void deleteAccount(@PathVariable String userId, @PathVariable String accountId) {

	}
}
