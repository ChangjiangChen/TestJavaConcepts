package com.algorithm.learn.test.unit1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
    private String name;
    @JsonIgnore
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
