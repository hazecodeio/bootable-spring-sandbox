package org.hsmak.hibernateWithEmbeddedDB;

import org.hsmak.hibernateWithEmbeddedDB.config.AppConfig;
import org.hsmak.hibernateWithEmbeddedDB.entity.User;
import org.hsmak.hibernateWithEmbeddedDB.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HibernateWihEmbeddedDBAppRunner {
    public static void main(String[] args) {
        ApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = appCtx.getBean(UserService.class);

        // Add Users
        userService.add(new User("Matt", "John", "Matt.John@example.com"));
        userService.add(new User("David", "Miller", "David.Miller@example.com"));
        userService.add(new User("Alice", "Biden", "Alice.Biden@example.com"));
        userService.add(new User("Paul", "Smith", "Paul.Smith@example.com"));

        // Get Users
        userService.listUsers().forEach(System.out::println);
    }
}
