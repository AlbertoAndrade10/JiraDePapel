package com.albertoandrade.jiradepapel.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.albertoandrade.jiradepapel.security.service.JwtService;
import com.albertoandrade.jiradepapel.user.application.usecase.CreateUserUseCase;
import com.albertoandrade.jiradepapel.user.application.usecase.FindUserUseCase;
import com.albertoandrade.jiradepapel.user.application.usecase.LoginUseCase;
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
    public LoginUseCase loginUseCase(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {

        return new LoginUseCase(userRepository, passwordEncoder, jwtService);
    }

    @Bean
    public FindUserUseCase findUserUseCase(UserRepository userRepository) {
        return new FindUserUseCase(userRepository);
    }
}
