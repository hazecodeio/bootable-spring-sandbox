package org.hsmak.hibernate.dao;

import org.hsmak.hibernate.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}