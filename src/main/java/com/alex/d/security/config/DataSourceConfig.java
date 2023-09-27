/*
package com.alex.d.security.config;

import com.alex.d.security.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {



    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://abul.db.elephantsql.com:5432/ckkttdhb");
        dataSourceBuilder.username("ckkttdhb");
        dataSourceBuilder.password("nozrUH1mHHpvvm8s9L_JPAgb1bm14w20");
        return dataSourceBuilder.build();
    }

    @Bean
    UserDetailsManager users(DataSource dataSource) {


        UserDetails user = User.builder()
                .username(userModel.getLogin())
                .password(userModel.getPassword())
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username(userModel.getLogin())
                .password(userModel.getPassword())
                .roles("ADMIN")
                .build();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.createUser(user);
        users.createUser(admin);
        return users;
    }
}

*/
