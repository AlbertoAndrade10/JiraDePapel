package com.albertoandrade.jiradepapel.user.domain.exception;

import com.albertoandrade.jiradepapel.common.domain.exception.DomainException;

public class UserNotFoundException extends DomainException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() {
        super("User not found");
    }
}
