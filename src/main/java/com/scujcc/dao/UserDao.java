package com.scujcc.dao;

import com.scujcc.entity.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by David on 4/6/17.
 */
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {
    /*
     * 通过名字来查询，参数为name。
     * 相当于JPQL:select u from User u where u.name = ?1
     */
    List<User> findByName(String name);
}
