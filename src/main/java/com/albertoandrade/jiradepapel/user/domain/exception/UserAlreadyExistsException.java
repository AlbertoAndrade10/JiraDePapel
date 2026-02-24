package com.albertoandrade.jiradepapel.user.domain.exception;

import com.albertoandrade.jiradepapel.common.domain.exception.DomainException;

public class UserAlreadyExistsException extends DomainException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }

    public UserAlreadyExistsException() {
        super("This email already exists");
    }
}
