package com.scujcc.service;

import com.scujcc.entity.User;

import java.util.List;

/**
 * Created by David on 4/7/17.
 */
public interface UserService {
    public User getUserById(int i);
    public List<User> getAllUser();
}
