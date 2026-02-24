package com.albertoandrade.jiradepapel.user.domain.repository;

import java.util.Optional;

import com.albertoandrade.jiradepapel.user.domain.model.User;
import com.albertoandrade.jiradepapel.user.domain.model.valueObjects.UserId;

/**
 * user domain repository
 */
public interface UserRepository {
    
    void save(User user);

    Optional<User> findById(UserId id);

    Optional<User> findByEmail(String email);
}
