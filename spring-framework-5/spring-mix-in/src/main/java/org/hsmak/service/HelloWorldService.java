package org.hsmak.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HelloWorldService {

    private static final Logger logger = LogManager.getLogger(HelloWorldService.class);

    public String getDescription() {

        logger.debug("getDescription() is executed!");

        return "Spring MVC Hello World Example";

    }

    public String getTitle(String name) {

        logger.debug("getTitle() is executed! $name : {}", name);

        if (!StringUtils.hasLength(name)) {
            return "Hello World";
        } else {
            return "Hello " + name;
        }

    }

}