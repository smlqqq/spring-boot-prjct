package com.alex.d.security.service;


import com.alex.d.security.models.RoleModel;
import com.alex.d.security.models.UserModel;
import com.alex.d.security.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;




    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }



//    @Override
//    public UserDetails loadUserByUsername(String login) {
//        UserModel user = userRepository.findByLogin(login)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + login));
//
//        return User.builder()
//                .username(user.getLogin())
//                .password(user.getPassword())
//                .authorities(user.getAuthorities())
//                .build();
//    }

    public UserModel registerUser(String name, String login, String password, Set<RoleModel> role) {
        if (name != null && !name.isEmpty() && login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
            if (userRepository.findByLogin(login).isPresent()) {
                System.out.println("This login is in use");
                return null;
            }

            UserModel userModel = new UserModel();
            userModel.setName(name);
            userModel.setLogin(login);
            userModel.setPassword(password);
            userModel.setRole(role);



            return userRepository.save(userModel);
        } else {
            System.out.println("Incorrect data");
            return null;
        }
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel user = userRepository.findByLogin(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found: " + username)
        );


//        return new User(user.getLogin(), user.getPassword(), authorities);
        return new MyUserDetails(user);
    }



}


