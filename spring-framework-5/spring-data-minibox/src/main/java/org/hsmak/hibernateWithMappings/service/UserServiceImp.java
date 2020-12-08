package org.hsmak.hibernateWithMappings.service;

import org.hsmak.hibernateWithMappings.dao.UserDao;
import org.hsmak.hibernateWithMappings.entity.User;
import org.hsmak.hibernateWithMappings.entity.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(isolation = Isolation.DEFAULT)
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

}
