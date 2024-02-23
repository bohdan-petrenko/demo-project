package com.bp.dp.api;

import com.bp.dp.api.model.UserDetails;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

	@PostMapping("sign-in")
	public void signIn(@RequestBody Object userData) {

	}

	@PostMapping("log-in")
	public void logIn(@RequestBody Object creds) {

	}

	@PostMapping("log-out")
	public void logOut() {

	}

	//todo check if you can easy hide user id in cookie
	@GetMapping("me")
	public UserDetails currentUser() {
		return null;
	}

	@GetMapping("{userId}")
	public UserDetails currentUser(@PathVariable String userId) {
		return null;
	}
}
