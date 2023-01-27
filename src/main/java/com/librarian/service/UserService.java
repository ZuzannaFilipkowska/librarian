package com.librarian.service;

import com.librarian.exception.ExceptionInfo;
import com.librarian.exception.UserWithGivenNameExists;
import com.librarian.model.AuthenticatedUserDto;
import com.librarian.model.NewUserDto;
import com.librarian.model.User;
import com.librarian.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserById(UUID id){
        return userRepository.findByUserId(id);
    }

    public void addUser(NewUserDto user) throws UserWithGivenNameExists {
        if (ifUserExists(user.username())) {
            throw new UserWithGivenNameExists(ExceptionInfo.USER_WITH_GIVEN_NAME_EXISTS.getMessage());
        }
        final User newUser = new User(user.username(), passwordEncoder.encode(user.pwd()));
        this.userRepository.save(newUser);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    public boolean hasRegistrationSucceed(NewUserDto user) {
        try {
            addUser(user);
            return true;
        } catch (UserWithGivenNameExists e) {
            return false;
        }
    }

    public AuthenticatedUserDto getAuthority() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        final Boolean isAdmin = Objects.equals(currentPrincipalName, "librarian");
        return new AuthenticatedUserDto(currentPrincipalName, isAdmin);
    }

    private Boolean ifUserExists(String name) {
        return getUserByName(name) != null;
    }

}
