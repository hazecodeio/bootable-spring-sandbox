package org.hsmak.jdbc;

import org.hsmak.jdbc.config.DBConfig;
import org.hsmak.jdbc.dao.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JDBCAppRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.getEnvironment().setActiveProfiles("h2"); // Necessary to activate profile before registering the config beans
        appContext.register(DBConfig.class);
        appContext.refresh();

        appContext.getBean(UserDaoImpl.class).findAll().stream().forEach(System.out::println);
    }
}

class AnotherRunner {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "derby");
        ApplicationContext appContext = new AnnotationConfigApplicationContext(DBConfig.class);
        appContext.getBean(UserDaoImpl.class).findAll().stream().forEach(System.out::println);
        System.out.println();

        System.setProperty("spring.profiles.active", "hsql");
        appContext = new AnnotationConfigApplicationContext(DBConfig.class);
        appContext.getBean(UserDaoImpl.class).findAll().stream().forEach(System.out::println);
        System.out.println();

        System.setProperty("spring.profiles.active", "h2");
        appContext = new AnnotationConfigApplicationContext(DBConfig.class);
        appContext.getBean(UserDaoImpl.class).findAll().stream().forEach(System.out::println);
        System.out.println();
    }
}