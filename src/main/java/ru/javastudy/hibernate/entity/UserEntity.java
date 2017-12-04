package ru.javastudy.hibernate.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users", schema = "", catalog = "public")
public class UserEntity {
    private int id;
    private String firstname;

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
    @Column(name = "firstname", columnDefinition = "", nullable = false, insertable = true, updatable = true, length = 60)
    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

}
