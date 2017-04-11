package com.scujcc.service;

import com.scujcc.entity.User;

import java.util.List;

/**
 * Created by David on 4/7/17.
 */
public interface UserService {
    User getUserById(int i);
    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser(int id);
}
