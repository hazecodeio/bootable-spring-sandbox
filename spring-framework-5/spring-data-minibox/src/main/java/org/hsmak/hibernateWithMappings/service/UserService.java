package org.hsmak.hibernateWithMappings.service;

import org.hsmak.hibernateWithMappings.entity.User;
import org.hsmak.hibernateWithMappings.entity.UserDetails;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
