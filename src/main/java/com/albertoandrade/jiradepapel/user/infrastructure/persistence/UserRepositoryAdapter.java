package com.albertoandrade.jiradepapel.user.infrastructure.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.albertoandrade.jiradepapel.user.domain.model.User;
import com.albertoandrade.jiradepapel.user.domain.model.UserRole;
import com.albertoandrade.jiradepapel.user.domain.model.valueObjects.UserId;
import com.albertoandrade.jiradepapel.user.domain.repository.UserRepository;

@Repository
public class UserRepositoryAdapter implements UserRepository {

    private final SpringDataUserRepository jpaRepository;

    public UserRepositoryAdapter(SpringDataUserRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void save(User user) {
        JpaUserEntity entity = new JpaUserEntity(
                user.getEmail(),
                user.getPassword(),
                user.getRole().name());
        jpaRepository.save(entity);
    }

    @Override
    public Optional<User> findById(UserId id) {
        return jpaRepository.findById(id.getValue())
                .map(this::toDomain);
    }

    @Override

    public Optional<User> findByEmail(String email) {
        return jpaRepository.findByEmail(email)
                .map(this::toDomain);
    }

    // ------ aux methods ------
    private User toDomain(JpaUserEntity entity) {
        return new User(
                UserId.from(entity.getId() != null ? UUID.fromString(entity.getId().toString()) : UUID.randomUUID()),
                entity.getEmail(),
                entity.getPassword(),
                UserRole.valueOf(entity.getRole()));
    }
}
