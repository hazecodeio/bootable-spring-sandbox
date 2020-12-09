package org.hsmak.jpaWithCrudRepositoryAndBidirMappings;

import org.hsmak.jpaWithCrudRepositoryAndBidirMappings.config.AppConfig;
import org.hsmak.jpaWithCrudRepositoryAndBidirMappings.entity.*;
import org.hsmak.jpaWithCrudRepositoryAndBidirMappings.repository.CarJpaRepository;
import org.hsmak.jpaWithCrudRepositoryAndBidirMappings.repository.UserJpaRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Set;

public class AppRunnerWithBidirMappings {
    public static void main(String[] args) {
        ApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);

        UserJpaRepository userJpaRepository = appCtx.getBean(UserJpaRepository.class);
        CarJpaRepository carJpaRepository = appCtx.getBean(CarJpaRepository.class);

        User user = new User("PaulUsername", "PaulPWD");
        user.setUserDetails(
                new UserDetails("Paul", "Smith", "Paul.Smith@example.com",
                        user)); // Assigning User for Bidirectionality
        user.setAddresses(Set.of(
                new Address(123, "some street", user), // Assigning User for Bidirectionality
                new Address(456, "Another street", user) // Assigning User for Bidirectionality
        ));

        Car car1 = new Car("Ford", "Mustang", user);
        Car car2 = new Car("Ford2", "Mustang2", user);
        user.setCars(Set.of(car1, car2));


        Project c1 = new Project(111, "Migrate To Java 11", Set.of(user));
        Project c2 = new Project(222, "Convert To Scala 3", Set.of(user));

        user.setProjects(Set.of(c1, c2));

        userJpaRepository.save(user);

        // The Bidirectionality allows to do the following as well without having duplicates for the  same user
        /*Car car1 = new Car("Ford", "Mustang", user);
        Car car2 = new Car("Ford2", "Mustang2", user);
        carJpaRepository.save(car1);
        carJpaRepository.save(car2);*/

        // Get Users
        userJpaRepository.findAll().forEach(System.out::println);
        System.out.println();

        carJpaRepository.findAll().forEach(System.out::println);
        System.out.println();
    }
}
