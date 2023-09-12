package com.alex.d.security.controller;

import com.alex.d.security.models.PatientsModel;
import com.alex.d.security.models.UserModel;
import com.alex.d.security.repositories.PatientsRepository;
import com.alex.d.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
        return "user/registration";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new UserModel());
        return "user/login";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserModel userModel) {
        System.out.println("Register request " + userModel);
        String encodedPassword = passwordEncoder.encode(userModel.getPassword());
        userModel.setPassword(encodedPassword);
        UserModel registeredUser = userService.registerUser(userModel.getName(), userModel.getLogin(), userModel.getPassword());
        return registeredUser == null ? "err/registration_error" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserModel userModel, Model model) {
        System.out.println("Login request " + userModel);
        UserModel authenticate = userService.authenthicate(userModel.getLogin(), userModel.getPassword());
        if (authenticate != null) {
            model.addAttribute("userLogin", authenticate.getLogin());
//            return "dashboard/user_dash";
            return "redirect:/patients";


        } else {
            return "err/error";
        }
    }

}
