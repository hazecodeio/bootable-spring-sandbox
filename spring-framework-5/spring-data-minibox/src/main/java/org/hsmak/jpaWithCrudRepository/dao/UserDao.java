package org.hsmak.jpaWithCrudRepository.dao;

import org.hsmak.jpaWithCrudRepository.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}