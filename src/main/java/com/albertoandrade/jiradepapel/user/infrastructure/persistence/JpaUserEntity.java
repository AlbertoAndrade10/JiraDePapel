package com.albertoandrade.jiradepapel.user.infrastructure.persistence;

import com.albertoandrade.jiradepapel.common.infrastructure.persistence.BaseJpaEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class JpaUserEntity extends BaseJpaEntity {

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    protected JpaUserEntity() { // <-- for JPA
    }

    public JpaUserEntity(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
