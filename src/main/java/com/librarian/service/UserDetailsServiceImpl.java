package com.librarian.service;

import com.librarian.model.User;
import com.librarian.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public  UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        final User user = userRepository.findUserByName(name);

        if (user == null) {
            throw new UsernameNotFoundException(name);
        }
        String role = Objects.equals(name, "librarian") ? "ADMIN" : "USER";

        return  org.springframework.security.core.userdetails.
                User
                .withUsername(user.getName())
                .password(user.getPasswordHash())
                .roles(role)
                .build();
    }

}
