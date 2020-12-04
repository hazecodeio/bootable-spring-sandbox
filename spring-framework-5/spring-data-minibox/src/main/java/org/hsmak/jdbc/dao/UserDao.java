package org.hsmak.jdbc.dao;

import org.hsmak.jdbc.model.User;

import java.util.List;

public interface UserDao {
    User findByName(String name);

    List<User> findAll();
}