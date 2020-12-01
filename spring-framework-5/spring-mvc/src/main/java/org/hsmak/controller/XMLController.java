package org.hsmak.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class XMLController {
    @RequestMapping(
            value = "/xml",
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody // Make sure Jackson jars are on the classpath
    public Person getXml() {
        return new Person();
    }

    static class Person {
        String name = "Kamala";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

