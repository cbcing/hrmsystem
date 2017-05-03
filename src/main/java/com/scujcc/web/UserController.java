package com.scujcc.web;

import com.scujcc.entity.Country;
import com.scujcc.entity.User;
import com.scujcc.service.CountryServiceImpl;
import com.scujcc.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

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

   @Autowired
    CountryServiceImpl countryService;

   @InitBinder
   private void dateBinder(WebDataBinder webDataBinder){
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
       CustomDateEditor customDateEditor = new CustomDateEditor(simpleDateFormat, true);
       webDataBinder.registerCustomEditor(Date.class, customDateEditor);
   }

    @ResponseBody
    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Country> add() {
        List<Country> countries = countryService.getAllCountries(); //得到所有的国家。

        return countries;
    }

    @RequestMapping(value = "/user/resultofadd", method = RequestMethod.POST)
    public String resultOfAdd(@ModelAttribute User user, BindingResult result, Model model) {
        userService.addUser(user);
        model.addAttribute("user", user);

        return "user-resultofadd";
    }

    @RequestMapping(value = "/user/showbyid", method = RequestMethod.POST)
    public String showById(@Param("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);

        return "user-showsingle";
    }

    @RequestMapping(value = "/user/showbyname", method = RequestMethod.POST)
    public String showByName(@Param("name") String name, Model model) {
       List user = userService.getUserByName(name);
       model.addAttribute("user", user);

       return "user-showsingle";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "user/showall", method = RequestMethod.GET)
    @ResponseBody
    private List<User> showAll() {
        List<User> users = userService.getAllUsers();

        return users;
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.GET)
    public String delete(@Param("id") int id) {
       userService.deleteUser(id);

       return "redirect:/user/showall";
    }
}