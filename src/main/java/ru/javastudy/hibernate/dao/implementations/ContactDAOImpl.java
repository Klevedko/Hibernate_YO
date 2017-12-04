package ru.javastudy.hibernate.dao.implementations;

import org.hibernate.Session;
import ru.javastudy.hibernate.entity.UserEntity;
import ru.javastudy.hibernate.dao.interfaces.ContactDAO;

import java.util.List;

public class ContactDAOImpl implements ContactDAO {

    private Session session;

    public List<UserEntity> findAll() {
        return session.createQuery("from UserEntity c").list();
    }

    public List<UserEntity> findAllWithDetail() {
        return null;
    }

    public UserEntity findById(Long id) {
        return null;
    }

    public UserEntity save(UserEntity contact) {
        return null;
    }

    public void delete(UserEntity contact) {
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
