package com.albertoandrade.jiradepapel.user.domain.exception;

import com.albertoandrade.jiradepapel.common.domain.exception.DomainException;

public class InvalidCredentialsException extends DomainException {

    public InvalidCredentialsException() {
        super("Invalid credentials");
    }

}
