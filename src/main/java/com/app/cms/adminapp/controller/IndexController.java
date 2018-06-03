package com.app.cms.adminapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    //user list
    @RequestMapping("/")
    String home(){
        return "redirect:/user/list";
    }

    @RequestMapping("/index")
    String index(){
        return "index";
    }
}
