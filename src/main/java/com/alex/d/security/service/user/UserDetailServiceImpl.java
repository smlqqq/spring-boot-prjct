package com.alex.d.security.service.user;


import com.alex.d.security.models.user.MyUserDetails;
import com.alex.d.security.models.user.RoleModel;
import com.alex.d.security.models.user.UserModel;
import com.alex.d.security.repositories.user.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

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




//            return userRepository.save(userModel);
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



//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserModel user = userRepository.findByLogin(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
//
//        return new org.springframework.security.core.userdetails.User(
//                user.getLogin(),
//                user.getPassword(),
//                getAuthorities(user.getRole())
//        );
//    }

    @Override
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
        UserModel user = userRepository.getUserByLogin(login);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(user);
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Set<RoleModel> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }




}


