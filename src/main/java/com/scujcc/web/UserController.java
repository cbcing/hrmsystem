package com.scujcc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by David on 4/6/17.
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/add")
    public String add(){
        return "user-add";
    }

    @RequestMapping("/show")
    public String show(){
        return "user-show";
    }
}