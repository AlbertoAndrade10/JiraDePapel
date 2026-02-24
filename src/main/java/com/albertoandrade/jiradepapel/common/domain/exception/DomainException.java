package com.albertoandrade.jiradepapel.common.domain.exception;

/**
 * base class for all domain exceptions.
 * it allows you to differentiate between business errors and infrastructure
 * errors.
 */
public class DomainException extends RuntimeException {

    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }

    public DomainException(Throwable cause) {
        super(cause);
    }

    public DomainException() {
        super("Domain exception");
    }
}
