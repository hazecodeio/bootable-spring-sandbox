package org.hsmak.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestJsonController {

    @RequestMapping(
            value = "/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonWrapper getJson() {
        return new PersonWrapper();
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

    static class PersonWrapper {

        Person person = new Person();

        public Person getPerson() {
            return person;
        }

        public void setPerson(Person person) {
            this.person = person;
        }
    }
}
