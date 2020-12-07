package org.hsmak.jpaWithCrudRepository.service;

import org.hsmak.jpaWithCrudRepository.dao.UserDao;
import org.hsmak.jpaWithCrudRepository.entity.User;
import org.hsmak.jpaWithCrudRepository.repository.UserWithCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
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
