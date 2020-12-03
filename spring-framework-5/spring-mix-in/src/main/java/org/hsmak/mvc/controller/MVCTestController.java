package org.hsmak.mvc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MVCTestController {

    private static final Logger logger = LogManager.getLogger(MVCTestController.class);

    /**
     * Selects the home page and populates the model with a message
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String home(Model model) {
        logger.info("Welcome home, test!");
        model.addAttribute("controllerMessage",
                "This is the message from the controller!");

        return "test";
    }
}
