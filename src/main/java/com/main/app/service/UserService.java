package com.main.app.service;

import com.main.app.domain.model.user.User;

import java.util.Optional;

/**
 * The service used for management of the User data.
 *
 *
 */
public interface UserService {
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
    User save(User user);
    User register(User user);
    Optional<User> getCurrentUser();
}
