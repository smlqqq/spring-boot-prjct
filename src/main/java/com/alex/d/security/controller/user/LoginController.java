package com.alex.d.security.controller.user;


import com.alex.d.security.SecurityApplication;
import com.alex.d.security.entity.user.UserModel;
import com.alex.d.security.service.user.UserDetailServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller

public final class LoginController {


    private final UserDetailServiceImpl userDetailService;
    private final BCryptPasswordEncoder passwordEncoder;


    public LoginController(UserDetailServiceImpl userDetailService, BCryptPasswordEncoder passwordEncoder) {
        this.userDetailService = userDetailService;
        this.passwordEncoder = passwordEncoder;
    }

    // Define logger for the class
    private final static Logger LOGGER = LogManager.getLogger(SecurityApplication.class);

    @PostMapping("/login")
    public String login(@ModelAttribute UserModel userModel, HttpSession session) {
        // Load user by username (login)
        UserDetails userDetails = userDetailService.loadUserByUsername(userModel.getLogin());
        LOGGER.info("Received login request. Username: {}", userModel.getLogin());

        if (userDetails != null) {
            // Check hashed password
            if (passwordEncoder.matches(userModel.getPassword(), userDetails.getPassword())) {
                // If authentication success, use userName and roles in session
                session.setAttribute("userName", userDetails.getUsername());
                session.setAttribute("userRoles", userDetails.getAuthorities());
                LOGGER.info("Authentication successful for user: {}", userDetails.getUsername());
                return "redirect:/list";
            }
        }


        // Authentication failed
        LOGGER.info("Authentication failed for user: {}", userModel.getLogin());
        return "err/error";
    }


    @GetMapping("/login")
    public String getLoginPage(Model model, HttpSession session) {
        // Проверяем, есть ли роли пользователя в сессии
        Collection<? extends GrantedAuthority> userRoles = (Collection<? extends GrantedAuthority>) session.getAttribute("userRoles");

        if (userRoles != null) {
            model.addAttribute("userRoles", userRoles);
            model.addAttribute("loginRequest", new UserModel());
        }

        return "user/login"; // Возвращаем шаблон для страницы входа
    }
}







