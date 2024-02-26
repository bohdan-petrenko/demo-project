package com.bp.dp.api;

import com.bp.dp.api.model.UserDetails;
import com.bp.dp.api.model.specific.SignUpRequest;
import com.bp.dp.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@PostMapping("sign-up")
	public void signUp(@RequestBody SignUpRequest signUpRequest) {
		userService.registerNewUser(signUpRequest);
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
