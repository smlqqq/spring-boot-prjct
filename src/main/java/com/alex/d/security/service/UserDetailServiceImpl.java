/*
package com.alex.d.security.service;

import com.alex.d.security.models.Role;
import com.alex.d.security.models.UserModel;
import com.alex.d.security.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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

        UserModel userModel = userRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с именем " + login + " не найден"));

        // Создайте объект UserDetails на основе информации из UserModel
        UserDetails user = User.builder()
                .username(userModel.getLogin())
                .password(userModel.getPassword())
                .roles("ADMIN", "USER")
                // Указать роли пользователя (если есть)
//                .roles("USER")
                .build();

        return user;
    }
}
*/
