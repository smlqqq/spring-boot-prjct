package com.alex.d.security.controller;

import com.alex.d.security.models.UserModel;
import com.alex.d.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder; // Инициализируйте BCryptPasswordEncoder

    @Autowired
    public UsersController(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder; // Инициализируйте passwordEncoder
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new UserModel());
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new UserModel());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserModel userModel) {
        System.out.println("Register request " + userModel);
        String encodedPassword = passwordEncoder.encode(userModel.getPassword());
        userModel.setPassword(encodedPassword);
        UserModel registeredUser = userService.registerUser(userModel.getLogin(), userModel.getPassword());
        return registeredUser == null ? "error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserModel userModel, Model model) {
        System.out.println("Login request " + userModel);
        UserModel authenticate = userService.authenthicate(userModel.getLogin(), userModel.getPassword());
        if (authenticate != null) {
            model.addAttribute("userLogin", authenticate.getLogin());
            return "personal_page";
        } else {
            return "error_page";
        }
    }
}
