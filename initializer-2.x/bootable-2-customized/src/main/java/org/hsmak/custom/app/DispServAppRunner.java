package org.hsmak.custom.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@SpringBootApplication(exclude = DispatcherServletAutoConfiguration.class)
@SpringBootApplication
//@Import({RestServletsConfig.class, MvcServletsConfig.class})
public class DispServAppRunner extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DispServAppRunner.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DispServAppRunner.class);
    }

}
