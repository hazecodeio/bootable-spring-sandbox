package org.hsmak.jpaWithCrudRepositoryAndUnidirMappings;

import org.hsmak.jpaWithCrudRepositoryAndUnidirMappings.config.AppConfig;
import org.hsmak.jpaWithCrudRepositoryAndUnidirMappings.entity.*;
import org.hsmak.jpaWithCrudRepositoryAndUnidirMappings.repository.CarJpaRepository;
import org.hsmak.jpaWithCrudRepositoryAndUnidirMappings.repository.UserJpaRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Set;

public class AppRunnerWithUnidirMappings {
    public static void main(String[] args) {
        ApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);

        UserJpaRepository userJpaRepository = appCtx.getBean(UserJpaRepository.class);
        CarJpaRepository carJpaRepository = appCtx.getBean(CarJpaRepository.class);

        User user = new User("PaulUsername", "PaulPWD");
        user.setUserDetails(new UserDetails("Paul", "Smith", "Paul.Smith@example.com"));
        user.setAddresses(Set.of(
                new Address(123, "some street"),
                new Address(456, "Another street")));


        Project c1 = new Project(111, "Migrate To Java 11");
        Project c2 = new Project(222, "Convert To Scala 3");

        user.setProjects(Set.of(c1, c2));
        userJpaRepository.save(user);

        Car car1 = new Car("Ford", "Mustang", user);
        Car car2 = new Car("Ford2", "Mustang2", user);
        carJpaRepository.save(car1);
        carJpaRepository.save(car2);

        // Get Users
        userJpaRepository.findAll().forEach(System.out::println);
        System.out.println();

        carJpaRepository.findAll().forEach(System.out::println);
        System.out.println();

    }
}
