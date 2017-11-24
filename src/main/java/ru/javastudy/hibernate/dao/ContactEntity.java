package ru.javastudy.hibernate.dao;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contact", schema = "", catalog = "public")
public class ContactEntity {
    private int id;
    private String firstname;
    private String lastname;
    private Date birthdate;
    private int version;
    private String testing;

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
    @Column(name = "lastname", columnDefinition = "", nullable = false, insertable = true, updatable = true, length = 40)
    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    //NOTE THIS!
    @Temporal(TemporalType.DATE)
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

    @Basic
    @Column(name = "testing", columnDefinition = "", nullable = true, insertable = true, length = 100)
    public String getTesting() {
        return testing;
    }

    public void setTesting(String testing) {
        this.testing = testing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactEntity that = (ContactEntity) o;

        if (id != that.id) return false;
        if (version != that.version) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (birthdate != null ? !birthdate.equals(that.birthdate) : that.birthdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 3111 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 3111 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 3111 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 3111 * result + version;
        return result;
    }

    @Override
    public String toString() {
        return "ContactEntity{" +
                "id=" + id +
                ", firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", birthDate=" + birthdate +
                ", version=" + version +
                '}';
    }
}
