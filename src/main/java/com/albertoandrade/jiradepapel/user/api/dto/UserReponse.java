package com.albertoandrade.jiradepapel.user.api.dto;

import java.util.UUID;

import com.albertoandrade.jiradepapel.user.domain.model.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReponse {

    private UUID id;
    private String email;
    private UserRole role;

    public UserReponse(UUID id, String email, UserRole role) {
        this.id = id;
        this.email = email;
        this.role = role;
    }
}
