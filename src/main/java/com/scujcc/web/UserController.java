package com.scujcc.web;

import com.scujcc.entity.User;
import com.scujcc.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by David on 4/6/17.
 */

@Controller
public class UserController {

   @Autowired
    UserServiceImpl userService;

   @InitBinder
   private void dateBinder(WebDataBinder webDataBinder){
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
       CustomDateEditor customDateEditor = new CustomDateEditor(simpleDateFormat, true);
       webDataBinder.registerCustomEditor(Date.class, customDateEditor);
   }

    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "user-add";
    }

    @RequestMapping(value = "/user/resultofadd", method = RequestMethod.POST)
    public String resultOfAdd(@ModelAttribute User user, BindingResult result, Model model) {
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
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "user-showall";
    }
}