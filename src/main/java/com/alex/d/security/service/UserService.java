package com.alex.d.security.service;

import com.alex.d.security.models.UserModel;
import com.alex.d.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public UserModel registerUser(String name, String login, String password) {
        if (name != null && !name.isEmpty() && login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
            if (userRepository.findFirstByLogin(login).isPresent()) {
                System.out.println("This login is in use");
                return null;
            }
            UserModel userModel = new UserModel();
            userModel.setName(name);
            userModel.setLogin(login);
            userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
//            userModel.setPassword(password);
            return userRepository.save(userModel);
        } else {
            System.out.println("Incorrect data");
            return null;
        }
    }

    public UserModel authenthicate (String login, String password) {
        Optional<UserModel> userOptional = userRepository.findByLogin(login);
        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();
            String hashedPassword = user.getPassword(); // Получите хешированный пароль из базы данных
            boolean passwordMatch = passwordEncoder.matches(password, hashedPassword); // Сравните хешированные пароли

            if (passwordMatch) {
                return user; // Верните UserModel, представляющий аутентифицированного пользователя
            }
        }
        return null; // Пользователь не найден или пароль не совпадает
    }


  /*  public UserModel authenthicate(String login, String password){
        System.out.println("Authenticating login: " + login + " with password: " + password);
        return userRepository.findByLoginAndPassword(login, password).orElse(null);
    }*/




}
