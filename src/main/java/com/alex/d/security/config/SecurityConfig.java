//package com.alex.d.security.config;
//
///*
//import com.alex.d.security.repositories.PatientsRepository;
//import com.alex.d.security.repositories.user.UserRepository;
//import com.alex.d.security.service.UserDetailServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig {
//
//    private final UserRepository userRepository;
//    private final PatientsRepository patientsRepository;
//
//    public SecurityConfig(UserRepository userRepository, PatientsRepository patientsRepository) {
//        this.userRepository = userRepository;
//        this.patientsRepository = patientsRepository;
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailServiceImpl(userRepository);
//    }
//
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                .authenticationProvider(authenticationProvider())
//                .build();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
//
//
//}
//*/
//
//
//import com.alex.d.security.repositories.user.UserRepository;
//import com.alex.d.security.service.UserDetailServiceImpl;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig {
//    private final Logger log = LoggerFactory.getLogger(SecurityConfig.class);
//
//    public SecurityConfig(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//    @Bean
//    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                .authenticationProvider(authenticationProvider())
//                .build();
//    }
//
//    private final UserRepository userRepository;
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailServiceImpl(userRepository);
//    }
//
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
//
////    @Bean
////    public SecurityFilterChain filterSecurity(HttpSecurity http) throws Exception {
////
////        http
////                .csrf(AbstractHttpConfigurer::disable)
////                .authorizeHttpRequests((authorize) -> authorize
////                        .requestMatchers("/admin_dash").hasRole("ADMIN")
////                        .requestMatchers("/user_dash").hasRole("USER")
////                        .requestMatchers("/", "/login", "/register", "/logout").permitAll()
//////                        .requestMatchers("/list").hasAnyRole("ADMIN", "USER")
////                        .requestMatchers("/list").hasAnyRole("ADMIN", "USER")
////                        .anyRequest().authenticated()
////                )
////                .formLogin(
////                        form -> form
////                                .loginPage("/login")
////                                .loginProcessingUrl("/login")
////                                .defaultSuccessUrl("/")
////                                .permitAll()
////                )
////                .logout(
////                        logout -> logout
////                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////                                .logoutSuccessUrl("/")
////                                .permitAll()
////                );
////        return http.build();
////    }
//
//    @Bean
//    public SecurityFilterChain filterSecurity(HttpSecurity http) throws Exception {
//
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests((authorize) -> authorize
//                        .requestMatchers("/admin_dash").hasRole("ADMIN")
//                        .requestMatchers("/user_dash").hasRole("USER")
//                        .requestMatchers("/", "/login", "/register", "/logout").permitAll()
////                        .requestMatchers("/list").hasAnyRole("ADMIN", "USER")
//                        .requestMatchers("/list").hasAnyRole("ADMIN", "USER")
//                        .anyRequest().authenticated()
//                )
//                .formLogin(
//                        form -> form
//                                .loginPage("/login")
//                                .loginProcessingUrl("/login")
//                                .defaultSuccessUrl("/")
//                                .permitAll()
//                )
//                .logout(
//                        logout -> logout
//                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                                .logoutSuccessUrl("/")
//                                .permitAll()
//                );
//        return http.build();
//    }
//}