package org.hsmak.hibernateWithMappings.dao;

import org.hsmak.hibernateWithMappings.entityUnidirectional.Car;
import org.hsmak.hibernateWithMappings.entityUnidirectional.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    void add(Car car);

    List<Car> listCars();
}