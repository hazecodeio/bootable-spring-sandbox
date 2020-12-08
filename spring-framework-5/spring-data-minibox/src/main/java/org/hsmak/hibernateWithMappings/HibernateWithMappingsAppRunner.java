package org.hsmak.hibernateWithMappings;

import org.hsmak.hibernateWithMappings.config.AppConfig;
import org.hsmak.hibernateWithMappings.entity.User;
import org.hsmak.hibernateWithMappings.entity.UserDetails;
import org.hsmak.hibernateWithMappings.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HibernateWithMappingsAppRunner {
    public static void main(String[] args) {
        ApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = appCtx.getBean(UserService.class);

        UserDetails userDetails = new UserDetails("Paul", "Smith", "Paul.Smith@example.com");
        User user = new User("username", "pwd");
        user.setUserDetails(userDetails);
//        userDetails.setAddress(user);
//        address.setUser(user);
        userService.add(user);

        // Get Users
        userService.listUsers().forEach(System.out::println);
    }
}
