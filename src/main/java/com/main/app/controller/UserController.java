package com.main.app.controller;

import com.main.app.domain.dto.ClinicDTO;
import com.main.app.domain.dto.Entities;
import com.main.app.domain.dto.UserDTO;
import com.main.app.domain.model.Clinic;
import com.main.app.domain.model.user.User;
import com.main.app.service.CurrentUserService;
import com.main.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path="/unconfirmedUsers")
    public ResponseEntity<Entities> getUnconfirmedUsers(Pageable page) {
        Entities result = new Entities();

        Page<User> users = userService.getUnconfirmedUsers(page);

        result.setEntities(users.getContent());
        result.setTotal(users.getTotalElements());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(path="/confirmUser/{id}")
    public ResponseEntity<UserDTO> confirmUser(@PathVariable Long id) {

        User user = userService.confirmUser(id);

        if(user == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
    }

    @PostMapping(path="/declineUser/{id}/{message}")
    public ResponseEntity<UserDTO> declineUser(@PathVariable Long id, @PathVariable String message) {

        User user = userService.declineUser(id, message);

        if(user == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
    }

    @PostMapping(path="/")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {

        User saved = userService.register(new User(userDTO));

        if(saved == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new UserDTO(saved), HttpStatus.OK);
    }

    @PostMapping(path="/activate/{token}")
    public ResponseEntity<UserDTO> activate(@PathVariable String token) {

        if(!userService.aktivate(token))
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping(path="/edit")
    public ResponseEntity<UserDTO> editUser(@RequestBody UserDTO userDTO) {

        User user = currentUserService.getCurrentUser().get();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setAddress(userDTO.getAddress());
        user.setCity(userDTO.getCity());
        user.setCountry(userDTO.getCountry());
        user.setPhoneNumber(userDTO.getPhoneNumber());

        User saved = userService.editProfile(user);

        return new ResponseEntity<>(new UserDTO(saved), HttpStatus.OK);
    }

    @GetMapping(path = "/rate/list")
    public ResponseEntity<Entities> getRateList(Pageable page) {
        Entities result = new Entities();

        List<User> users = userService.getRateList(page);

        result.setEntities(users);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(path = "/rate/{doctorId}/{rate}")
    public ResponseEntity<UserDTO> rate(@PathVariable long doctorId, @PathVariable int rate) {

        User saved = userService.rate(doctorId, rate);
        return new ResponseEntity<>(new UserDTO(saved), HttpStatus.OK);
    }
}
