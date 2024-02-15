package com.alex.d.security.service.user;


import com.alex.d.security.entity.user.UserModel;
import com.alex.d.security.repositories.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserDetailServiceImpl.class);
    private final UserRepository userRepository;



    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;


    }



  /*  @Override
    public MyUserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserModel user = userRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with login: " + login));
        LOGGER.info("Load user by login" + user.getLogin());


        if (user == null) {
            throw new UsernameNotFoundException("User not found with login: " + login);
        }

        List<SimpleGrantedAuthority> authorities = user.getRole() != null ?
                user.getRole().stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                        .toList() :
                Collections.emptyList();


//        return new MyUserDetails(user);

        return (MyUserDetails) User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }*/


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

            LOGGER.info("User saved successfully" + userRepository.save(userModel));

            return userRepository.save(userModel);
        } else {
            LOGGER.info("Data is incorrect");
            return null;
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel user = userRepository.findByLogin(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found: " + username)
        );


//        return new User(user.getLogin(), user.getPassword(), authorities);
        return (UserDetails) user;
    }



//    public UserModel findUserById(Long userId) {
//        Optional<UserModel> userFromDb = userRepository.findById(userId);
//        return userFromDb.orElse(new UserModel());
//    }
//
//    public List<UserModel> allUsers() {
//        return userRepository.findAll();
    }

//    public boolean saveUser(UserModel user) {
//        Optional<UserModel> userFromDB = userRepository.findByLogin(user.getLogin());
//
//        if (userFromDB != null) {
//            return false;
//        }
//
//        user.setRole(Collections.singleton(new RoleModel(1L, "ROLE_USER")));
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//        return true;
//    }
//
//    public boolean deleteUser(Long userId) {
//        if (userRepository.findById(userId).isPresent()) {
//            userRepository.deleteById(Math.toIntExact(userId));
//            return true;
//        }
//        return false;
//    }






