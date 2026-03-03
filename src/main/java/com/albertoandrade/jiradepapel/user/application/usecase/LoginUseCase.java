package com.albertoandrade.jiradepapel.user.application.usecase;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.albertoandrade.jiradepapel.security.service.JwtService;
import com.albertoandrade.jiradepapel.user.domain.exception.InvalidCredentialsException;
import com.albertoandrade.jiradepapel.user.domain.model.User;
import com.albertoandrade.jiradepapel.user.domain.repository.UserRepository;

@Component
public class LoginUseCase {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginUseCase(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String execute(String email, String rawPassword) {
        Optional<User> userOpt = userRepository.findByEmail(email);

        User user = userOpt.orElseThrow(InvalidCredentialsException::new);

        boolean matches = passwordEncoder.matches(rawPassword, user.getPassword());

        if (!matches) {
            throw new InvalidCredentialsException();
        }
        return jwtService.generateToken(
                user.getEmail(),
                user.getRole().name());
    }
}
