package com.albertoandrade.jiradepapel.user.application.usecase;

import java.util.Optional;

import com.albertoandrade.jiradepapel.user.domain.exception.UserNotFoundException;
import com.albertoandrade.jiradepapel.user.domain.model.User;
import com.albertoandrade.jiradepapel.user.domain.model.valueObjects.UserId;
import com.albertoandrade.jiradepapel.user.domain.repository.UserRepository;

public class FindUserUseCase {
    private final UserRepository userRepository;

    public FindUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> execute(UserId id) {
        return Optional.ofNullable(userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new));
    }
}
