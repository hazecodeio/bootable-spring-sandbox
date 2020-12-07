package org.hsmak.jpa;

import org.hsmak.jpa.config.AppConfig;
import org.hsmak.jpa.entity.User;
import org.hsmak.jpa.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JpaAppRunner {
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
    }
}
