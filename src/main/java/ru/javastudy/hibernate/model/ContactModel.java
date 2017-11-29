package ru.javastudy.hibernate.model;
import org.springframework.stereotype.Component;


public class ContactModel {
    private int id;
    private String surname;

    // дефолт конструктор
    public ContactModel() {
    }

    public ContactModel(int id, String surname) {
        this.id = id;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(String name) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String password) {
        this.surname = surname;
    }
}
