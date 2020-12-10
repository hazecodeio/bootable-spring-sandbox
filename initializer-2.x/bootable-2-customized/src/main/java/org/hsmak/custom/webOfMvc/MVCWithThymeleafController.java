package org.hsmak.custom.webOfMvc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class MVCWithThymeleafController {

    private Logger logger = LogManager.getLogger(MVCWithThymeleafController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {

        logger.info("Welcome to home(), Anonymous!");

        model.addAttribute("welcomeMsg", "Welcome home, Anonymous!! <- From Controller :)");

        return "index";
    }

    @RequestMapping(value = "/{name:.+}", method = RequestMethod.GET)
    public String requestWithMapReturningViewsName(@PathVariable("name") String name, Map<String, Object> model) {

        logger.debug("requestWithMapReturningViewsName() is executed!");

        model.put("welcomeMsg", "Welcome home!");
        model.put("name", name);

        return "index2"; // MVC Controller will always return the View's name or ModelAndView which ha the view's name
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView requestReturningModelAndView(@RequestParam String name,
                                                     @RequestParam String id) {

        logger.debug("requestReturningModelAndView() is executed - $name {} $id {}", name, id);

        ModelAndView model = new ModelAndView();
        model.addAllObjects(Map.of("name", name, "id" , id, "welcomeMsg", "Welcome home!"));
        model.setViewName("index3");

        return model; // MVC Controller will always return the View's name or ModelAndView which ha the view's name
    }
}