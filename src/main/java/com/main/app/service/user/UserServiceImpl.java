package com.main.app.service.user;

import com.main.app.domain.model.user.User;
import com.main.app.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The implementation of the service used for management of the User data.
 *
 *
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private CurrentUserService currentUserService;

    @Autowired
    public UserServiceImpl(
            UserRepository repository,
            CurrentUserService currentUserService
    ) {
        this.userRepository = repository;
        this.currentUserService = currentUserService;
    }



    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }


    public Optional<User> findById(Long id) {
        return userRepository.findOneById(id);
    }


    public User save(User user) {
        return userRepository.save(user);
    }


}
