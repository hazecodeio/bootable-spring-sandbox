package org.hsmak.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestPlainTextController {

    @RequestMapping(
            value = "/",
            produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody // Make sure Jackson jars are on the classpath
    public String getText(@RequestParam(required = false) String id) {
        return "This is a String by id: " + id;
    }

    @RequestMapping(
            value = "/text/{name}",
            produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody // Make sure Jackson jars are on the classpath
    public String getTextByPath(@PathVariable String name, @RequestParam(required = false) String id) {
        return String.format("This is a String by name (%s) and id(%s)", name, id);
    }
}
