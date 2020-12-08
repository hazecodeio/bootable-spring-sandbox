package org.hsmak.jpaWithCrudRepositoryAndBidirMappings.dao;

import org.hsmak.jpaWithCrudRepositoryAndBidirMappings.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}