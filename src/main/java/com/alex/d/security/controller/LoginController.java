package com.alex.d.security.controller;

import com.alex.d.security.models.UserModel;
import com.alex.d.security.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public final class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new UserModel());
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserModel userModel, HttpSession session) {
        System.out.println("Login request " + userModel);
        UserModel authenticate = userService.authenticate(userModel.getLogin(), userModel.getPassword());
        if (authenticate != null) {
            session.setAttribute("userName", authenticate.getName());
            return "redirect:/list";
        } else {
            return "err/error";
        }
    }
}
