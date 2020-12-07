package org.hsmak.jpaWithCrudRepository;

import org.hsmak.jpaWithCrudRepository.config.AppConfig;
import org.hsmak.jpaWithCrudRepository.entity.User;
import org.hsmak.jpaWithCrudRepository.repository.UserWithCrudRepository;
import org.hsmak.jpaWithCrudRepository.repository.UserWithJpaRepository;
import org.hsmak.jpaWithCrudRepository.repository.UserWithPagingAndSortingRepository;
import org.hsmak.jpaWithCrudRepository.service.UserServiceWithJpaRepository;
import org.hsmak.jpaWithCrudRepository.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JpaWithCrudRepositoryAppRunner {
    public static void main(String[] args) {
        ApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = appCtx.getBean(UserService.class);

        // Add Users
        userService.add(new User("Matt", "John", "Matt.John@example.com"));
        userService.add(new User("David", "Miller", "david.miller@example.com"));
        userService.add(new User("Alice", "Biden", "Alice.Biden@example.com"));
        userService.add(new User("Paul", "Smith", "paul.smith@example.com"));

        // Get Users
        userService.listUsers().forEach(System.out::println);
        System.out.println();

        appCtx.getBean(UserWithCrudRepository.class).findAll().forEach(System.out::println);
        System.out.println();
        appCtx.getBean(UserWithPagingAndSortingRepository.class).findAll().forEach(System.out::println);
        System.out.println();
        appCtx.getBean(UserWithJpaRepository.class).findAll().forEach(System.out::println);
        System.out.println();

        appCtx.getBean(UserServiceWithJpaRepository.class).findAll().forEach(System.out::println);
        System.out.println();


        appCtx.getBean(UserServiceWithJpaRepository.class).save(new User("1111", "2222", "11111.2222@example.com"));
        System.out.println();

        appCtx.getBean(UserServiceWithJpaRepository.class).findAll().forEach(System.out::println);
        System.out.println();


    }
}
