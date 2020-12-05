package org.hsmak.jpa.dao;

import org.hsmak.jpa.entity.User;

import java.util.List;

public interface UserDao {
    void add(org.hsmak.jpa.entity.User user);

    List<User> listUsers();
}