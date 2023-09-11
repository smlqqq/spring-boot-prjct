package com.alex.d.security.models;


import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import java.util.Objects;


@Repository
@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;

    @Column(name = "name")
     String username;

    @Column(name = "login")
     String login;

    @Column(name = "password")
     String password;


    public UserModel() {
    }

    public UserModel(String name, String password, String login) {
        this.username = name;
        this.password = password;
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(id, userModel.id) && Objects.equals(username, userModel.username) && Objects.equals(login, userModel.login) && Objects.equals(password, userModel.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, login, password);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
