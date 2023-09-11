package com.alex.d.security.controller;

import com.alex.d.security.models.UserModel;
import com.alex.d.security.service.UserAuthService;
import com.alex.d.security.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {



    UserAuthService userAuthService;


    public AuthController(UserAuthService userAuthService) {

        this.userAuthService= userAuthService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new UserModel());
        return "auth/register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new UserModel());
        return "auth/login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserModel userModel) {
        System.out.println("Register request " + userModel);
        UserModel registeredUser = userAuthService.registerUser(userModel.getLogin() , userModel.getPassword(), userModel.getName());
        return registeredUser == null ? "error_register" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserModel userModel, Model model) {
        System.out.println("Login request " + userModel);
        UserModel authenthicate = userAuthService.authenthicate(userModel.getLogin(), userModel.getPassword());
        if (authenthicate != null) {
            model.addAttribute("userLogin", authenthicate.getLogin());
            return "user/personal_page";
        } else {
            return "error_page";
        }
    }
}
