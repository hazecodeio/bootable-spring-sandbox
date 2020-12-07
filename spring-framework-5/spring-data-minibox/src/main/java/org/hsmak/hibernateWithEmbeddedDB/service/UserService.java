package org.hsmak.hibernateWithEmbeddedDB.service;

import org.hsmak.hibernateWithEmbeddedDB.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
