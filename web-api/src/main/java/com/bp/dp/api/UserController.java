package com.bp.dp.api;

import com.bp.dp.api.model.UserDetails;
import com.bp.dp.api.model.specific.LogInRequest;
import com.bp.dp.api.model.specific.SignUpRequest;
import com.bp.dp.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
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
	private final AuthenticationManager authenticationManager;

	@PostMapping("sign-up")
	public void signUp(@RequestBody SignUpRequest signUpRequest) {
		userService.registerNewUser(signUpRequest);
	}

	@PostMapping("log-in")
	public void logIn(@RequestBody @Valid LogInRequest credentials, HttpServletRequest request) {

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				credentials.login(),
				credentials.password()
		));
		setSessionAuth(request.getSession(), authentication);
	}

	//todo check what does this do
	private void setSessionAuth(HttpSession session, Authentication auth) {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(auth);
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);
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
