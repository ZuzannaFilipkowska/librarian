package com.librarian.controller;

import com.librarian.model.AuthenticatedUserDto;
import com.librarian.model.NewUserDto;
import com.librarian.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {this.userService = userService;}

    @PostMapping("/register")
    public ResponseEntity<NewUserDto> register(@RequestBody NewUserDto newUser) {
        return this.userService.hasRegistrationSucceed(newUser) ? ResponseEntity.status(HttpStatus.CREATED).body(newUser) : ResponseEntity.badRequest().build();
    }

    @GetMapping()
    public AuthenticatedUserDto getAuthority() {
        return this.userService.getAuthority();
    }

}
