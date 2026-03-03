package com.albertoandrade.jiradepapel.user.application.usecase;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.albertoandrade.jiradepapel.user.domain.exception.InvalidUserDataException;
import com.albertoandrade.jiradepapel.user.domain.exception.UserAlreadyExistsException;
import com.albertoandrade.jiradepapel.user.domain.model.User;
import com.albertoandrade.jiradepapel.user.domain.model.UserRole;
import com.albertoandrade.jiradepapel.user.domain.model.valueObjects.UserId;
import com.albertoandrade.jiradepapel.user.domain.repository.UserRepository;

public class CreateUserUseCase {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateUserUseCase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User execute(String email, String rawPassword, UserRole role) {

        String encodedPassword = passwordEncoder.encode(rawPassword);

        if (email == null || email.isBlank()) {
            throw new InvalidUserDataException("email is required");
        }

        userRepository.findByEmail(email).ifPresent(u -> {
            throw new UserAlreadyExistsException();
        });

        User user = new User(UserId.random(), email, encodedPassword, role);
        userRepository.save(user);
        return user;
    }
}
