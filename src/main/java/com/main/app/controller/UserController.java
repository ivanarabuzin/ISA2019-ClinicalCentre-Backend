package com.main.app.controller;

import com.main.app.domain.dto.user.UserDTO;
import com.main.app.service.user.CurrentUserService;
import com.main.app.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller exposing API for register drivers and customers.
 *
 * URL : /user
 *
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserController {


    private UserService userService;

    private CurrentUserService currentUserService;

    public static final int PASSWORD_MIN_LENGTH = 6;

    public static final int PASSWORD_MAX_LENGTH = 100;


    @Autowired
    public UserController(
            UserService userService,
            CurrentUserService currentUserService
    ) {
        this.userService = userService;
        this.currentUserService = currentUserService;
    }


    @GetMapping(path="/current")
    public ResponseEntity<UserDTO> getCurrentUser() {
        return new ResponseEntity<>(
                currentUserService.getCurrentUserDTO(),
                HttpStatus.OK
        );
    }
}
