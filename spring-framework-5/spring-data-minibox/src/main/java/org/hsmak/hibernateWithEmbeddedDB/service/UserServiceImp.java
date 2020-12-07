package org.hsmak.hibernateWithEmbeddedDB.service;

import org.hsmak.hibernateWithEmbeddedDB.dao.UserDao;
import org.hsmak.hibernateWithEmbeddedDB.entity.User;
import org.hsmak.hibernateWithEmbeddedDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) {
        userDao.add(user);
    }

//    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

}
