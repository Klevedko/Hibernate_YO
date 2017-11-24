package ru.javastudy.hibernate.model;

import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class User {

    private String name;
    private String password;
    private String label;

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
