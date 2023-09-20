package com.alex.d.security.controller;


import com.alex.d.security.models.UserModel;
import com.alex.d.security.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UsersController {
    //MVC
    //REST
    private final UserService userService;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UsersController(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
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

    @PostMapping("/register")
    public String register(@ModelAttribute UserModel userModel) {
        System.out.println("Register request " + userModel);
        String encodedPassword = passwordEncoder.encode(userModel.getPassword());
        userModel.setPassword(encodedPassword);
        UserModel registeredUser = userService.registerUser(userModel.getName(), userModel.getLogin(), userModel.getPassword());
        return registeredUser == null ? "err/registration_error" : "redirect:/login";
    }


}
