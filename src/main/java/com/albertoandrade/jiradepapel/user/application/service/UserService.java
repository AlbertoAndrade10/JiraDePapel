package com.albertoandrade.jiradepapel.user.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.albertoandrade.jiradepapel.user.application.usecase.CreateUserUseCase;
import com.albertoandrade.jiradepapel.user.application.usecase.FindUserUseCase;
import com.albertoandrade.jiradepapel.user.domain.model.User;
import com.albertoandrade.jiradepapel.user.domain.model.UserRole;
import com.albertoandrade.jiradepapel.user.domain.model.valueObjects.UserId;

@Service
public class UserService {
    private final CreateUserUseCase createUserUseCase;
    private final FindUserUseCase findUserUseCase;

    public UserService(CreateUserUseCase createUserUseCase, FindUserUseCase findUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.findUserUseCase = findUserUseCase;
    }

    public User createUser(String email, String password, UserRole role) {
        return createUserUseCase.execute(email, password, role);

    }

    public Optional<User> findById(UserId id) {
        return findUserUseCase.execute(id);
    }
}
