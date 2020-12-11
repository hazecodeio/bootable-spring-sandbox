package org.hsmak.mvc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class MvcController {

    @Value("${welcomeMessage}")
    private String welcomeMsg;

    @GetMapping("/")
    public ModelAndView home(){ // MCV Controller

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addAllObjects(Map.of("welcomeMsg", welcomeMsg));
        modelAndView.setViewName("home");
        return modelAndView;
    }

    //////////////////////// Below is a REST Controller //////////////////////

    @GetMapping(
            value = "/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Person json(){
        return new Person();
    }
    class Person{
        String name = "James";
        int id = 123456;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
