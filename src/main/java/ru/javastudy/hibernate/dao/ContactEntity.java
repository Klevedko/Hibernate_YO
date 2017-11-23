package ru.javastudy.hibernate.dao;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Nick on 05.09.2015.
 */
@Entity
@Table(name = "contact", schema = "", catalog = "public")
public class ContactEntity {
    private int id;
    private String firstname;
    private String lasTname;
    private Date birthdate;
    private int version;

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

    @Basic
    @Column(name = "lasTname",columnDefinition = "", nullable = false, insertable = true, updatable = true, length = 40)
    public String getLastName() {
        return lasTname;
    }

    public void setLastName(String lasTname) {
        this.lasTname = lasTname;
    }

    //NOTE THIS!
    @Temporal(TemporalType.DATE) //in table uses java.sql.Date, we use java.util.Date.
    @Column(name = "birthdate", nullable = true, insertable = true, updatable = true)
    public java.util.Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    //NOTE THIS!
    @Version
    @Column(name = "version", nullable = false, insertable = true, updatable = true)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactEntity that = (ContactEntity) o;

        if (id != that.id) return false;
        if (version != that.version) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lasTname != null ? !lasTname.equals(that.lasTname) : that.lasTname != null) return false;
        if (birthdate != null ? !birthdate.equals(that.birthdate) : that.birthdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lasTname != null ? lasTname.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 31 * result + version;
        return result;
    }

    @Override
    public String toString() {
        return "ContactEntity{" +
                "id=" + id +
                ", firstName='" + firstname + '\'' +
                ", lastName='" + lasTname + '\'' +
                ", birthDate=" + birthdate +
                ", version=" + version +
                '}';
    }
}
