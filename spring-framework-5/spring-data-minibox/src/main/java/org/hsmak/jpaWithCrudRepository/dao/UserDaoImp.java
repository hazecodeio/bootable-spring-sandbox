package org.hsmak.jpaWithCrudRepository.dao;

import org.hsmak.jpaWithCrudRepository.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager; // Replacing Hibernate's SessionFactory


    @Override
    public void add(User user) {
//        sessionFactory.getCurrentSession().save(user);
        entityManager.persist(user);
    }

    @Override
    public List<User> listUsers() {
       /*TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();*/

        Query from_user = entityManager.createQuery("from User");

        return from_user.getResultList();
    }

}
