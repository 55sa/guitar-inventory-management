package com.homework2.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Guitar_Customer")
public class Customer {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;


    public Customer(){

    }
    public Customer(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public String username() {
        return username;
    }

    public String password() {
        return password;
    }

    public String email() {
        return email;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}

