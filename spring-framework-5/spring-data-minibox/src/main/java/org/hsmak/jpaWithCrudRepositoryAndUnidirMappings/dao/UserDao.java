package org.hsmak.jpaWithCrudRepositoryAndUnidirMappings.dao;

import org.hsmak.jpaWithCrudRepositoryAndUnidirMappings.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}