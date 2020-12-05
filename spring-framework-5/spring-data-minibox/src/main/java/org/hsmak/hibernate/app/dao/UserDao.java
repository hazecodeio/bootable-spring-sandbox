package org.hsmak.hibernate.app.dao;

import org.hsmak.hibernate.app.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}