package com.main.app.service;

import com.main.app.domain.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The service used for management of the User data.
 *
 *
 */
@Service
public interface UserService {
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
    User save(User user);
    User editProfile(User user);
    User register(User user);
    Optional<User> getCurrentUser();
    boolean aktivate(String token);
    Page<User> getUnconfirmedUsers(Pageable pageable);
    User confirmUser(Long id);
    User declineUser(Long id, String message);
}
