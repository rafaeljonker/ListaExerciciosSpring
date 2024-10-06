package com.example.bean_validation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue
    Long id;
    String login;
    String password;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public User(){

    }

    public User(String login, String password, String name){
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


}
