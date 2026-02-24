package com.albertoandrade.jiradepapel.user.domain.exception;

import com.albertoandrade.jiradepapel.common.domain.exception.DomainException;

public class InvalidUserDataException extends DomainException {

    public InvalidUserDataException(String message) {
        super(message);
    }
}
