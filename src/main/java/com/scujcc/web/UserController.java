package com.scujcc.web;

import com.scujcc.entity.User;
import com.scujcc.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by David on 4/6/17.
 */

@Controller
public class UserController {

   @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String add(Model model) {
        System.out.println("add()");
        model.addAttribute("user", new User());
        return "user-add";
    }

    @RequestMapping(value = "/user/resultofadd", method = RequestMethod.POST)
    public String resultOfAdd(@ModelAttribute User user, Model model) {
        System.out.println("resultOfAdd()");
        System.out.println(user.getName());
        System.out.println(user.getSex());
        System.out.println(user.getBirthday());
        System.out.println(user.getHeight());
        System.out.println(user.getWeight());
        System.out.println(user.getMaritalStatus());
        System.out.println(user.getCountry());
        System.out.println(user.getTypeOfCertificate());
        System.out.println(user.getNumberOfCertificate());

        userService.addUser(user);
        model.addAttribute("user", user);

        return "user-resultofadd";
    }

    @RequestMapping(value = "user/showbyid", method = RequestMethod.POST)
    public String showById(@Param("id") int id, Model model) {

        User user = userService.getUserById(id);

        model.addAttribute("userofone", user);

        return "user-showbyid";
    }

    @RequestMapping(value = "user/showall", method = RequestMethod.GET)
    private String showAll(Model model) {

        List<User> users = userService.getAllUser();

        model.addAttribute("users", users);

        return "user-showall";
    }
}