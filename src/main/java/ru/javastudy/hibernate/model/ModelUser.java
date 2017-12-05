package ru.javastudy.hibernate.model;
import org.springframework.stereotype.Component;

public class ModelUser {

    private int id;
    private String password;

    public ModelUser(int id, String password) {
        this.id = id;
        this.password = password;
    }
    public ModelUser(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
