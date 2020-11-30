package org.hsmak.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlainTextController {

    @RequestMapping(
            value = "/text",
            produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody // Make sure Jackson jars are on the classpath
    public String getText() {
        return "This is a String";
    }
}
