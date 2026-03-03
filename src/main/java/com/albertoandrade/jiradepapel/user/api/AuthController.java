package com.albertoandrade.jiradepapel.user.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albertoandrade.jiradepapel.user.api.dto.LoginRequest;
import com.albertoandrade.jiradepapel.user.application.usecase.LoginUseCase;
import com.albertoandrade.jiradepapel.user.domain.model.User;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final LoginUseCase loginUseCase;

    public AuthController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest request) {
        User user = loginUseCase.execute(request.getEmail(), request.getPassword());
        return ResponseEntity.ok("Login successful for user: " + user.getEmail());
    }
}
