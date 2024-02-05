package com.alex.d.security.controller.user;


import com.alex.d.security.entity.user.UserModel;
import com.alex.d.security.service.user.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public final class RegistrationController {


//    private final UserService userService;
    private final UserDetailServiceImpl userDetailService;
    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public RegistrationController( UserDetailServiceImpl userDetailService, BCryptPasswordEncoder passwordEncoder ) {
        this.userDetailService = userDetailService;
        this.passwordEncoder = passwordEncoder;

    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserModel userModel) {
        System.out.println("Register request " + userModel);
        String encodedPassword = passwordEncoder.encode(userModel.getPassword());
        userModel.setPassword(encodedPassword);
        UserModel registeredUser = userDetailService.registerUser(
                userModel.getName(),
                userModel.getLogin(),
                userModel.getPassword()

        );
        return registeredUser == null ? "err/registration_error" : "redirect:/login";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new UserModel());
        return "user/registration";
    }
}


