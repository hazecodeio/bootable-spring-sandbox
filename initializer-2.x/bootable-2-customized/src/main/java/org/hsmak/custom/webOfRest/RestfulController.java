package org.hsmak.custom.webOfRest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(value = "/")
public class RestfulController {

//    @RequestMapping("/")
    @GetMapping("/")
    public String getRequest() {
        return "From a REST Controller";
    }
}
