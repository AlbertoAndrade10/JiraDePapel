package com.albertoandrade.jiradepapel.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.albertoandrade.jiradepapel.user.application.usecase.CreateUserUseCase;
import com.albertoandrade.jiradepapel.user.application.usecase.FindUserUseCase;
import com.albertoandrade.jiradepapel.user.domain.repository.UserRepository;

@Configuration
public class UserUseCaseConfig {

    @Bean
    public CreateUserUseCase createdUserUseCase(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        return new CreateUserUseCase(userRepository, passwordEncoder);
    }

    @Bean
    public FindUserUseCase findUserUseCase(UserRepository userRepository) {
        return new FindUserUseCase(userRepository);
    }
}
