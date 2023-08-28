package com.spring.application.service;

import com.spring.application.model.User;

public interface UserService {
    User createUser(User user);

   // User getUserById(Long id);

    //List<User> getAllUsers();

    User updateUser(Long id, User updatedUser);

    User findByUsername(String username);

    void deleteUser(Long id);
}
