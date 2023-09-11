package com.alex.d.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class AdminController {
    @RequestMapping(value = {"/admin/dashboard"}, method = RequestMethod.GET)
    public String adminHome(){
        return "admin/dashboard";
    }
}
