/*
package com.alex.d.security.config;

*/
/*
import com.alex.d.security.repositories.PatientsRepository;
import com.alex.d.security.repositories.UserRepository;
import com.alex.d.security.service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final UserRepository userRepository;
    private final PatientsRepository patientsRepository;

    public SecurityConfig(UserRepository userRepository, PatientsRepository patientsRepository) {
        this.userRepository = userRepository;
        this.patientsRepository = patientsRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailServiceImpl(userRepository);
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(authenticationProvider())
                .build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }


}
*//*





import com.alex.d.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig {



    private final UserRepository userRepository;


    public SecurityConfig(UserRepository userRepository) {

        this.userRepository = userRepository;

    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }




 */
/*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {

        auth.jdbcAuthentication().dataSource().withUser().pa;
        auth.inMemoryAuthentication().withUser("user")
                .password(passwordEncoder().encode("password")).roles("USER");
    }*//*




   */
/* @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/, /login, /signup, /logout").permitAll()
                        .requestMatchers("/api").hasRole("ADMIN")
                        .requestMatchers("/user").hasRole("USER")
                        .anyRequest().authenticated())
                .logout().logoutUrl("/logout").logoutSuccessUrl("/").and()
                .formLogin().loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/user").failureUrl("/login?error");
        return http.build();
    }*//*



*/
/*  @Bean
    public UserDetailsService users(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        // Create a default user with a secure password and the "ROLE_USER" role
        UserDetails defaultUser = User.withUsername("your_username_here")
                .password("{bcrypt}$2a$10$1234567890abcdefghijklmnopqrstuvwxyz")
                .roles("ROLE_USER")
                .build();

        users.createUser(defaultUser);

        return users;
    }*//*




 */
/*   @Bean
    public UserDetailsService users(DataSource dataSource) {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username(userModel.getName())
                .password("password")
                .roles("USER")
                .build();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.createUser(user);
        return users;
    }*//*





    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
*/
/* .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/admin_dash").hasRole("ADMIN")
                        .requestMatchers("/user_dash").hasRole( "USER")
                        .requestMatchers("/", "/login", "/registration", "/logout").permitAll()
                        .requestMatchers("/list").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated()*//*





                .authorizeHttpRequests(requests -> requests


                        .requestMatchers("/admin_dash").hasRole("ADMIN")
                        .requestMatchers("/user_dash").hasRole("USER")
                        .requestMatchers("/", "/login", "/register", "/logout").permitAll()
//                        .requestMatchers("/list").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated()

*/
/*   .authorizeHttpRequests((authorize) ->
                        authorize.anyRequest().authenticated()*//*


                )

                .formLogin(form -> form
                        .loginPage("/login")
//                        .loginProcessingUrl("/list")
                        .defaultSuccessUrl("/list", true)
                        .failureUrl("/")
                        .permitAll()
                )

                .logout(logout -> logout
                        .logoutUrl("logout")
                        .logoutSuccessUrl("/")
                        .permitAll());

        return http.build();
    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
//    }


 @Bean
    JdbcUserDetailsManager users(DataSource dataSource){
         JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
         return jdbcUserDetailsManager;
    }

}
*/
