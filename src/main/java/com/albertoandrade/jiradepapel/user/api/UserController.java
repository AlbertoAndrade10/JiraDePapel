package com.albertoandrade.jiradepapel.user.api;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albertoandrade.jiradepapel.user.api.dto.CreateUserRequest;
import com.albertoandrade.jiradepapel.user.api.dto.UserResponse;
import com.albertoandrade.jiradepapel.user.application.service.UserService;
import com.albertoandrade.jiradepapel.user.domain.model.User;
import com.albertoandrade.jiradepapel.user.domain.model.valueObjects.UserId;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {

        User user = userService.createUser(request.getEmail(), request.getPassword(), request.getRole());

        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("id") String id) {

        Optional<User> userOpt = userService.findById(UserId.from(UUID.fromString(id)));

        return userOpt.map(user -> ResponseEntity.ok(toResponse(user)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private UserResponse toResponse(User user) {

        return new UserResponse(
                user.getId().getValue(),
                user.getEmail(),
                user.getUserRole());
    }
}
