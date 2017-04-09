package com.scujcc.service;

import com.scujcc.dao.UserDao;
import com.scujcc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by David on 4/7/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getUserById(int i) {
        User user = userDao.findOne(i);

        return user;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        Iterator iterator = userDao.findAll().iterator();
        while (iterator.hasNext()) {
            users.add((User)iterator.next());
        }
        return users;
    }

    @Override
    public void addUser(User user){
        userDao.save(user);
    }
}
