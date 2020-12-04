package org.hsmak.bootstrap;

import org.hibernate.SessionFactory;
import org.hsmak.bootstrap.config.HibernateConf;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(HibernateConf.class);
        ctx.getBean(SessionFactory.class);

    }
}
