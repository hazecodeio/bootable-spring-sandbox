package org.hsmak.hibernateWithMappings.dao;

import org.hsmak.hibernateWithMappings.entity.User;
import org.hsmak.hibernateWithMappings.entity.UserDetails;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}