package com.main.app.domain.model.user;

import com.main.app.domain.model.AbstractEntity;
import com.main.app.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;


/**
 * The user entity representing all users of the system.
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
public class User extends AbstractEntity {

    @NotNull
    private String password;

    @NotNull
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    private String resetToken;

    private Instant resetTokenExpirationDate;

    private String deviceToken;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User(@NotNull String password, @NotNull String email, @NotNull String name, @NotNull String surname) {
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
    }
}