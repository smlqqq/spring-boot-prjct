package com.alex.d.security.controller;


import com.alex.d.security.models.UserModel;
import com.alex.d.security.service.UserDetailServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public final class LoginController {

//    private final UserService userService;
    private final UserDetailServiceImpl userDetailService;
    private final BCryptPasswordEncoder passwordEncoder;



    public LoginController(UserDetailServiceImpl userDetailService, BCryptPasswordEncoder passwordEncoder) {
        this.userDetailService = userDetailService;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new UserModel());
        return "user/login";
    }

//    @PostMapping("/login")
//    public String login(@ModelAttribute UserModel userModel, HttpSession session) {
//        System.out.println("Login request " + userModel);
//        UserModel authenticate = userService.authenticate(userModel.getLogin(), userModel.getPassword());
//        if (authenticate != null) {
//            session.setAttribute("userName", authenticate.getName());
//            return "redirect:/list";
//        } else {
//            return "err/error";
//        }
//    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserModel userModel, HttpSession session) {
        System.out.println("Login request " + userModel);
        // Load user by username (login)
        UserDetails userDetails = userDetailService.loadUserByUsername(userModel.getLogin());
        if (userDetails != null) {
            // Check hashed password
            if (passwordEncoder.matches(userModel.getPassword(), userDetails.getPassword())) {
                // If authenthicatin succes, use userName in session
                session.setAttribute("userName", userDetails.getUsername());
                return "redirect:/list";
            }
        }
        // else
        return "err/error";
    }
}
