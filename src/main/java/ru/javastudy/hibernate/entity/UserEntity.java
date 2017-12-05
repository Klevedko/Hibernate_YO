package ru.javastudy.hibernate.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users", schema = "", catalog = "public")
public class UserEntity {
    private int id;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "password", columnDefinition = "", nullable = false, insertable = true, updatable = true, length = 60)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
