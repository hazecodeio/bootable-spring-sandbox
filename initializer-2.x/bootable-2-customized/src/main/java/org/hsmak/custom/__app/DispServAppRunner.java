package org.hsmak.custom.__app;

import org.hsmak.custom._configOfGlobe.FiltersConfig;
import org.hsmak.custom._configOfGlobe.ServletsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/*
 * SpringBootServletInitializer:
 *      - Link: https://www.baeldung.com/spring-boot-war-tomcat-deploy
 *      - Build as a WAR
 *      - Deploy to Tomcat Server
 */

@SpringBootApplication(exclude = DispatcherServletAutoConfiguration.class)
//@SpringBootApplication()
@Import({ServletsConfig.class, FiltersConfig.class})
public class DispServAppRunner extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DispServAppRunner.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DispServAppRunner.class);
    }

    @Bean
    public DispatcherServletPath dispatcherServletPath() {
        DispatcherServletPath dispatcherServletPath = new DispatcherServletPath() {
            @Override
            public String getPath() {
                return "/";
            }

        };
        return dispatcherServletPath;
    }

}
