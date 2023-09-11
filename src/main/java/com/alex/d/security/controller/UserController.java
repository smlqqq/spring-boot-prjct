package com.alex.d.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class UserController {
    @RequestMapping(value = {"/user/dashboard"}, method = RequestMethod.GET)
    public String userHome(){
        return "user/dashboard";
    }
}
