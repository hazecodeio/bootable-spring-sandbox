package org.hsmak.hibernateWithEmbeddedDB.dao;

import org.hsmak.hibernateWithEmbeddedDB.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}