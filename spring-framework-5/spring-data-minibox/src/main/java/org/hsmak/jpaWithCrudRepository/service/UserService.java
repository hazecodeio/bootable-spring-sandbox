package org.hsmak.jpaWithCrudRepository.service;

import org.hsmak.jpaWithCrudRepository.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
