package com.albertoandrade.jiradepapel.user.domain.model.valueObjects;

import java.util.Objects;
import java.util.UUID;

/**
 * Value object to identify a user
 */
public final class UserId {
    private final UUID id;

    private UserId(UUID id) {
        this.id = id;
    }

    public static UserId from(UUID id) {
        Objects.requireNonNull(id, "UserId cannot be null");
        return new UserId(id);
    }

    public static UserId random() {
        return new UserId(UUID.randomUUID());
    }

    public UUID getValue() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof UserId))
            return false;
        UserId userId = (UserId) obj;

        return id.equals(userId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
