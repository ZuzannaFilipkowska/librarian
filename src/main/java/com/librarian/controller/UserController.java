package com.librarian.controller;

import com.librarian.model.NewUserDto;
import com.librarian.model.User;
import com.librarian.model.UserDto;
import com.librarian.service.UserService;
import org.apache.http.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {this.userService = userService;}

    @PostMapping("/register")
    public ResponseEntity<NewUserDto> register(@RequestBody NewUserDto newUser) {
        return this.userService.hasRegistrationSucceed(newUser) ? ResponseEntity.status(HttpStatus.CREATED).body(newUser) : ResponseEntity.badRequest().build();
    }

}
