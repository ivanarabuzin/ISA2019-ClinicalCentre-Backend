package com.main.app.service;

import com.main.app.config.SecurityUtils;
import com.main.app.domain.model.user.User;
import com.main.app.repository.user.UserRepository;
import com.main.app.service.email.RegistrationEmailService;
import com.main.app.staticData.StaticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private RegistrationEmailService registrationEmailService;

    @Value("${spring.deeplink}")
    private String deeplinkUrl;

    @Value("${spring.mail.username}")
    private String emailFrom;

    @Autowired
    public UserServiceImpl(
            UserRepository repository,
            CurrentUserService currentUserService,
            RegistrationEmailService registrationEmailService
    ) {
        this.userRepository = repository;
        this.currentUserService = currentUserService;
        this.registrationEmailService = registrationEmailService;
    }

    public Optional<User> getCurrentUser() {
        Optional<String> username = SecurityUtils.getCurrentUserLogin();

        return this.userRepository.findOneByEmail(username.get());
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

    @Override
    public User register(User user) {
        User savedUser = userRepository.save(user);

        registrationEmailService.sendEmail(
                deeplinkUrl,
                "?registrationToken=" + savedUser.getRegistrationToken(),
                emailFrom,
                savedUser.getEmail(),
                StaticData.URL_PART_Deliverer
        );

        return savedUser;
    }
}
