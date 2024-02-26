package com.bp.dp.service;

import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

import com.bp.dp.api.model.UserRoles;
import com.bp.dp.api.model.specific.SignUpRequest;
import com.bp.dp.document.UserDocument;
import com.bp.dp.exception.api.UserAlreadyExistsException;
import com.bp.dp.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;

	public UserDocument registerNewUser(SignUpRequest signUpRequest) throws UserAlreadyExistsException {
		//todo add boolean exists method
		Optional<UserDocument> maybeUser = userRepository.findByEmail(signUpRequest.email());
		if (maybeUser.isPresent()) {
			throw new UserAlreadyExistsException(maybeUser.get());
		}

		UserDocument userDocument = toUserDocument(signUpRequest);
		return userRepository.save(userDocument);
	}

	//todo add mapstruct
	private UserDocument toUserDocument(SignUpRequest signUpRequest) {
		UserDocument userDocument = new UserDocument();
		userDocument.setEmail(signUpRequest.email());
		userDocument.setPhoneNumber(signUpRequest.phoneNumber());
		userDocument.setFirstName(signUpRequest.firstName());
		userDocument.setLastName(signUpRequest.lastName());
		long dateOfBirth = signUpRequest.dateOfBirth().atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
		userDocument.setDateOfBirthMillisUtc(dateOfBirth);
		userDocument.setPasswordEncrypted(passwordEncoder.encode(signUpRequest.password()));
		userDocument.setAccounts(List.of());
		userDocument.setAuthorities(List.of(UserRoles.ROLE_USER.name()));
		return userDocument;
	}
}
