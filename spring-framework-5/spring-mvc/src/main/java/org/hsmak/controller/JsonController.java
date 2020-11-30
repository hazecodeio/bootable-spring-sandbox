package org.hsmak.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {

    @RequestMapping(
            value = "/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody // Make sure Jackson jars are on the classpath
    public PersonWrapper getJson() {
        return new PersonWrapper();
    }

}

class PersonWrapper {

    Person person = new Person();

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

class Person {
    String name = "Kamala";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}