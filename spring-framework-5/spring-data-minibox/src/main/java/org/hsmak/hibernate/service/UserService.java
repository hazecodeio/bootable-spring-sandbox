package org.hsmak.hibernate.service;

import org.hsmak.hibernate.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
