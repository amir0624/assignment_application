package com.spring.application.service;

import com.spring.application.model.User;
import com.spring.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
    public class UserServiceImpl implements UserService {

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Override
        public User createUser(User user) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }

//    @Override
//    public List<User> getAllUsers() {
//        return null;
//    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        return null;
    }

    @Override
        public User findByUsername(String username) {
            return userRepository.findByUsername(username);
        }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

