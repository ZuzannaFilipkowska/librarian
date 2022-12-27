package com.librarian.service;

import com.librarian.model.User;
import com.librarian.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    @Autowired
    public  UserDetailsServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

//    public void addNewUser(User user) {
//        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
//        userRepository.save(user);
//    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        final User user = userRepository.findUserByName(name);

        if (user == null) {
            throw new UsernameNotFoundException(name);
        }
        return  org.springframework.security.core.userdetails.
                User
                .withUsername(user.getName())
                .password(user.getPasswordHash())
                .roles("USER")
                .build();
    }
}
