package com.scujcc.dao;

import com.scujcc.entity.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by David on 4/6/17.
 */
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {
}
