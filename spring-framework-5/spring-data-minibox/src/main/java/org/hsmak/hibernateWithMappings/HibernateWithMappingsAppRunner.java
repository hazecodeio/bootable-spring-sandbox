package org.hsmak.hibernateWithMappings;

import org.hsmak.hibernateWithMappings.config.AppConfig;
import org.hsmak.hibernateWithMappings.entityUnidirectional.Address;
import org.hsmak.hibernateWithMappings.entityUnidirectional.Car;
import org.hsmak.hibernateWithMappings.entityUnidirectional.User;
import org.hsmak.hibernateWithMappings.entityUnidirectional.UserDetails;
import org.hsmak.hibernateWithMappings.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Set;

public class HibernateWithMappingsAppRunner {
    public static void main(String[] args) {
        ApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = appCtx.getBean(UserService.class);


        User user = new User("username", "pwd");
        user.setUserDetails(new UserDetails("Paul", "Smith", "Paul.Smith@example.com"));
        user.setAddresses(Set.of(
                new Address(123, "some street"),
                new Address(456, "Another street")));
        userService.add(user);

        Car car1 = new Car("Ford", "Mustang", user);
        Car car2 = new Car("Ford2", "Mustang2", user);
        userService.add(car1);
        userService.add(car2);


        // Get Users
        userService.listUsers().forEach(System.out::println);
        System.out.println();

        userService.listCars().forEach(System.out::println);
    }
}
