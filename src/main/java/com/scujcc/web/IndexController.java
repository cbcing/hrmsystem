package com.scujcc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by David on 4/6/17.
 */

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
