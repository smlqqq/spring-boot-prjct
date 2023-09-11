package com.alex.d.security.service;

import com.alex.d.security.models.UserModel;
import com.alex.d.security.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;



    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;

    }
   /* public UserModel registerUser(String login, String password, String name) {
        if (login != null && !login.isEmpty() && password != null && !password.isEmpty() && name != null && !name.isEmpty()) {
            if (userRepository.findFirstByLogin(login).isPresent()) {
                System.out.println("Дублирующийся логин");
                return null;
            }

            UserModel userModel = new UserModel();
            userModel.setLogin(login);

            // Хешируйте пароль перед сохранением в базу данных
            String hashedPassword = bCryptPasswordEncoder.encode(password);
            userModel.setPassword(hashedPassword);

//            UserModel userModel = new UserModel();
//            userModel.setLogin(login);
//            userModel.setPassword(password);

            userModel.setName(name);
            return userRepository.save(userModel);
        } else {
            System.out.println("Некорректные данные для регистрации");
            return null;
        }
    }
    public UserModel authenthicate(String login, String password){
        System.out.println("Authenticating login: " + login + " with password: " + password);
        return userRepository.findByLoginAndPassword(login, password).orElse(null);
    }*/

}