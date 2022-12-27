//package com.librarian.service;
//
//import com.librarian.exception.ExceptionInfo;
//import com.librarian.exception.UserWithGivenNameExists;
//import com.librarian.model.User;
//import com.librarian.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class UserService {
//
////    private final UserDetailsServiceImpl userDetailsService;
//    private final UserRepository userRepository;
//    @Autowired
//    public UserService(UserRepository userRepository){
//        this.userRepository = userRepository;
////        this.userDetailsService = userDetailsService;
//    }
//
//    public User getUserById(UUID id){
//        return userRepository.findByUserId(id);
//    }
//
////    public void addUser(User user) throws UserWithGivenNameExists {
////        if (ifUserExists(user.getName())) {
////            throw new UserWithGivenNameExists(ExceptionInfo.USER_WITH_GIVEN_NAME_EXISTS.getMessage());
////        }
////        userDetailsService.addNewUser(user);
////    }
////
////    public List<User> getAllUsers() {
////        return userRepository.findAll();
////    }
////
////    public User getUserByName(String name) {
////        return userRepository.findUserByName(name);
////    }
////
////    public boolean hasRegistrationSucceed(User user) {
////        try {
////            addUser(user);
////            return true;
////        } catch (UserWithGivenNameExists e) {
////            return false;
////        }
////    }
////
////    private Boolean ifUserExists(String name) {
////        return getUserByName(name) != null;
////    }
//}
