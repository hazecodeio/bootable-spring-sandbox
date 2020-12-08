package org.hsmak.hibernateWithMappings.service;

import org.hsmak.hibernateWithMappings.dao.UserDao;
import org.hsmak.hibernateWithMappings.entityUnidirectional.Car;
import org.hsmak.hibernateWithMappings.entityUnidirectional.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(isolation = Isolation.DEFAULT)
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public void add(Car car) {
        userDao.add(car);
    }

    @Override
    public List<Car> listCars() {
        return userDao.listCars();
    }

}
