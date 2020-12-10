package org.hsmak.custom.webOfMvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(value = "/")
public class MvcController {

//    @RequestMapping("/")
    @GetMapping("/")
    public String getRequest() {
        return "From a MVC Controller";
    }
}
