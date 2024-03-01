package com.bp.dp.security;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.bp.dp.document.UserDocument;
import com.bp.dp.repository.UserRepository;
import com.bp.dp.util.EmailUtils;
import com.bp.dp.util.MobilePhoneUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MongoDbUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmailOrPhone) throws UsernameNotFoundException {
        //todo use mapped model value, not a document
        Optional<UserDocument> maybeUser = findUserByEmailOrPhone(userEmailOrPhone);
        if (maybeUser.isEmpty()) {
            throw new UsernameNotFoundException(String.format("User with email or phone: %s not found", userEmailOrPhone));
        }
        UserDocument user = maybeUser.get();
        Set<SimpleGrantedAuthority> grantedAuthorities = user
                .getAuthorities()
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());

        return new User(user.getEmail(), user.getPasswordEncrypted(), grantedAuthorities);
    }

    //todo move to standalone service
    private Optional<UserDocument> findUserByEmailOrPhone(String userEmailOrPhone) {
        if (EmailUtils.isEmailValid(userEmailOrPhone)) {
            String email = EmailUtils.unifiedEmail(userEmailOrPhone);
            return userRepository.findByEmail(email);

        } else if (MobilePhoneUtils.isMobilePhoneNumberValid(userEmailOrPhone)) {
            String phoneNumber = MobilePhoneUtils.unifiedMobilePhoneNumber(userEmailOrPhone);
            return userRepository.findByPhoneNumber(phoneNumber);
        } else {
            log.info("User email or phone invalid: {}", userEmailOrPhone);
            return Optional.empty();
        }
    }
}