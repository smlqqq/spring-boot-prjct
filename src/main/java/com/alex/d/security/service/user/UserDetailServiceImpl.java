package com.alex.d.security.service.user;


import com.alex.d.security.entity.user.UserModel;
import com.alex.d.security.repositories.user.RoleRepository;
import com.alex.d.security.repositories.user.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserDetailServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;

        this.roleRepository = roleRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserModel user = userRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with login: " + login));


        if (user == null) {
            throw new UsernameNotFoundException("User not found with login: " + login);
        }

        List<SimpleGrantedAuthority> authorities = user.getRole() != null ?
                user.getRole().stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                        .collect(Collectors.toList()) :
                Collections.emptyList();



        return User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }


    public UserModel registerUser(String name, String login, String password) {
        if (name != null && !name.isEmpty() && login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
            if (userRepository.findByLogin(login).isPresent()) {
                System.out.println("This login is in use");
                return null;
            }

            UserModel userModel = new UserModel();
            userModel.setName(name);
            userModel.setLogin(login);
            userModel.setPassword(password);

            return userRepository.save(userModel);
        } else {
            System.out.println("Incorrect data");
            return null;
        }
    }


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        UserModel user = userRepository.findByLogin(username).orElseThrow(() ->
//                new UsernameNotFoundException("User not found: " + username)
//        );
//
//
////        return new User(user.getLogin(), user.getPassword(), authorities);
//        return new MyUserDetails(user);
//    }

}


