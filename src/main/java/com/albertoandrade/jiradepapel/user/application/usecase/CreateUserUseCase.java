package com.albertoandrade.jiradepapel.user.application.usecase;

import com.albertoandrade.jiradepapel.user.domain.exception.InvalidUserDataException;
import com.albertoandrade.jiradepapel.user.domain.exception.UserAlreadyExistsException;
import com.albertoandrade.jiradepapel.user.domain.model.User;
import com.albertoandrade.jiradepapel.user.domain.model.UserRole;
import com.albertoandrade.jiradepapel.user.domain.model.valueObjects.UserId;
import com.albertoandrade.jiradepapel.user.domain.repository.UserRepository;

public class CreateUserUseCase {
    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String email, String password, UserRole role) {

        if (email == null || email.isBlank()) {
            throw new InvalidUserDataException("email is required");
        }

        userRepository.findByEmail(email).ifPresent(u -> {
            throw new UserAlreadyExistsException();
        });

        User user = new User(UserId.random(), email, password, role);
        userRepository.save(user);
        return user;
    }
}
