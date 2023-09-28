package com.alex.d.security.service;

import com.alex.d.security.models.UserModel;
import com.alex.d.security.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login)  {
        // Здесь вы должны запросить пользователя из вашей базы данных по его логину (username)
        // и вернуть объект UserDetails, представляющий этого пользователя.

        // Ниже приведен пример:

        UserModel user = userRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с именем " + login + " не найден"));

//        Collection<GrantedAuthority> authorities = user.getAuthorities(); // Retrieve user's authorities (roles)
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities(); // Retrieve user's authorities (roles)

        /*return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                authorities
        );*/

         return User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .authorities(authorities)
                .build();




        // Создайте объект UserDetails на основе информации из UserModel
        /* return User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
//                .roles(user.getRoleModel())
                .build();*/


    }

  /*  @Override
    public UserDetails loadUserByUsername(String login) {
       UserModel user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + login);
        }
        List<RoleModel> roles = user.getRoles(); // Retrieve roles associated with the user
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                roles.stream().map(Role::getName).toArray(String[]::new)
        );
    }*/
}
