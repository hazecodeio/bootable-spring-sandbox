package org.hsmak.hibernate.app.service;

import org.hsmak.hibernate.app.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
