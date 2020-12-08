package org.hsmak.jpaWithCrudRepositoryAndMappings.dao;

import org.hsmak.jpaWithCrudRepositoryAndMappings.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}