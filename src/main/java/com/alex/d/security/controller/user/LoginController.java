package com.alex.d.security.controller.user;


import com.alex.d.security.models.user.UserModel;
import com.alex.d.security.service.user.UserDetailServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public final class LoginController {


    private final UserDetailServiceImpl userDetailService;
    private final BCryptPasswordEncoder passwordEncoder;



    public LoginController(UserDetailServiceImpl userDetailService, BCryptPasswordEncoder passwordEncoder) {
        this.userDetailService = userDetailService;
        this.passwordEncoder = passwordEncoder;
    }


   /* @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new UserModel());
        return "user/login";
    }*/

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

/*    @PostMapping("/login")
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
    }*/

    @PostMapping("/login")
    public String login(@ModelAttribute UserModel userModel, HttpSession session) {
        // Load user by username (login)
        UserDetails userDetails = userDetailService.loadUserByUsername(userModel.getLogin());

        if (userDetails != null) {
            // Check hashed password
            if (passwordEncoder.matches(userModel.getPassword(), userDetails.getPassword())) {
                // If authentication success, use userName and roles in session
                session.setAttribute("userName", userDetails.getUsername());
                session.setAttribute("userRoles", userDetails.getAuthorities());
                return "redirect:/list";
            }
        }

        // Authentication failed
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
