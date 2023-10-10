//package com.alex.d.security.service;
//
//import com.alex.d.security.models.user.RoleModel;
//import com.alex.d.security.models.user.UserModel;
//
//import com.alex.d.security.repositories.user.UserRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.Optional;
//
//@Service
//public class UserService {
//    private final BCryptPasswordEncoder passwordEncoder;
//    private final UserRepository userRepository;
//
//
//    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//
//    }
//    public UserModel registerUser(String name, String login, String password) {
//        if (name != null && !name.isEmpty() && login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
//            if (userRepository.findByLogin(login).isPresent()) {
//                System.out.println("This login is in use");
//                return null;
//            }
//            UserModel userModel = new UserModel();
//            userModel.setName(name);
//            userModel.setLogin(login);
//            userModel.setPassword(password);
//
//
//            return userRepository.save(userModel);
//        } else {
//            System.out.println("Incorrect data");
//            return null;
//        }
//    }
//
//    public UserModel authenticate (String login, String password) {
//        Optional<UserModel> userOptional = userRepository.findByLogin(login);
//        if (userOptional.isPresent()) {
//            UserModel user = userOptional.get();
//            String hashedPassword = user.getPassword(); // get hash password
//            boolean passwordMatch = passwordEncoder.matches(password, hashedPassword);
//            if (passwordMatch) {
//                return user; // return UserModel
//            }
//        }
//        return null; // return null if user is not available
//    }
//
//
////    public UserModel authenticate(String login, String password, Collection<RoleModel> rolesToCheck) {
////        Optional<UserModel> userOptional = userRepository.findByLogin(login);
////        if (userOptional.isPresent()) {
////            UserModel user = userOptional.get();
////            String hashedPassword = user.getPassword();
////            boolean passwordMatch = passwordEncoder.matches(password, hashedPassword);
////            if (passwordMatch && userHasRoles(user, rolesToCheck)) {
////                return user; // Возвращаем UserModel только если пароль совпадает и у пользователя есть нужные роли
////            }
////        }
////        return null; // Возвращаем null, если пользователь не аутентифицирован или не имеет нужных ролей
////    }
////
////    private boolean userHasRoles(UserModel user, Collection<RoleModel> rolesToCheck) {
////        // Проверяем, есть ли у пользователя все указанные роли
////        return user.getRoleModel().containsAll(rolesToCheck);
////    }
//
//
//
//
//  /*  public UserModel authenthicate(String login, String password){
//        System.out.println("Authenticating login: " + login + " with password: " + password);
//        return userRepository.findByLoginAndPassword(login, password).orElse(null);
//    }*/
//
//
//
//
//}