package com.albertoandrade.jiradepapel.user.domain.model;

import java.util.Objects;

import com.albertoandrade.jiradepapel.user.domain.model.valueObjects.UserId;

import lombok.Getter;
import lombok.Setter;

/**
 * Root user added
 */
@Getter
@Setter
public class User {

    private final UserId id;
    private String email;
    private String password;
    private UserRole role;

    public User(UserId id, String email, String password, UserRole role) {
        this.id = Objects.requireNonNull(id, "id cannot be null");
        this.email = Objects.requireNonNull(email, "email cannot be null");
        this.password = Objects.requireNonNull(password, "password cannot be null");
        this.role = Objects.requireNonNull(role, "role cannot be null");
    }

}
