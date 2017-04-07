package com.scujcc.web;

import com.scujcc.dao.UserDao;
import com.scujcc.entity.User;
import com.scujcc.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 4/6/17.
 */

@Controller
@RequestMapping("/user")
public class UserController {

   @Autowired
    UserServiceImpl userService;

    @RequestMapping("/add")
    public String add() {
        return "user-add";
    }

    @RequestMapping("/showbyid")
    public String showById(@Param("id") int id, Model model) {

        User user = userService.getUserById(id);

        model.addAttribute("userofone", user);

        return "user-showbyid";
    }

    @RequestMapping("/showall")
    private String showAll(Model model) {

        List<User> users = userService.getAllUser();

        model.addAttribute("users", users);

        return "user-showall";
    }
}