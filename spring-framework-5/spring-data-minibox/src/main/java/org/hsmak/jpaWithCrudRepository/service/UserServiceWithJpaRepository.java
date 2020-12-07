package org.hsmak.jpaWithCrudRepository.service;

import org.hsmak.jpaWithCrudRepository.entity.User;
import org.hsmak.jpaWithCrudRepository.repository.UserWithJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Transactional // Only needed when an EntityManager is used directly down the call
public class UserServiceWithJpaRepository {
    @Autowired
    UserWithJpaRepository userWithJpaRepository;

    public List<User> findAll(){
        return userWithJpaRepository.findAll();
    }

    public User save(User u){
         return userWithJpaRepository.save(u);
    }
}
