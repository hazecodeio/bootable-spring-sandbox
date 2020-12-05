package org.hsmak.hibernate;

import org.hsmak.hibernate.config.AppConfig;
import org.hsmak.hibernate.entity.User;
import org.hsmak.hibernate.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = appCtx.getBean(UserService.class);

        // Add Users
        userService.add(new User("Sunil", "Bora", "suni.bora@example.com"));
        userService.add(new User("David", "Miller", "david.miller@example.com"));
        userService.add(new User("Sameer", "Singh", "sameer.singh@example.com"));
        userService.add(new User("Paul", "Smith", "paul.smith@example.com"));

        // Get Users
        userService.listUsers().forEach(System.out::println);
    }
}
