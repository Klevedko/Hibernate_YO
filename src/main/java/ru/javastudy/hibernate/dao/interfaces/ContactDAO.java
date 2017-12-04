package ru.javastudy.hibernate.dao.interfaces;

import ru.javastudy.hibernate.entity.UserEntity;

import java.util.List;

/**
 * Created by Nick on 06.09.2015.
 */
public interface ContactDAO {

    // Найти все контакты.
    public List<UserEntity> findAll();

    // Найти все контакты с заданным телефоном и хобби.
    public List<UserEntity> findAllWithDetail();

    // Найти контакт со всеми деталями по идентификатору.
    public UserEntity findById(Long id);

    // Вставить или обновить контакт.
    public UserEntity save(UserEntity contact);

    // Удалить контакт.
    public void delete(UserEntity contact);
}