package org.hsmak.reactive.controller;

import org.hsmak.reactive.repository.CommentRepository;
import org.hsmak.reactive.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

@Controller
public class ReactiveMvcController {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/movies")
    public String moviesGetRequest(final Model model) {

        // loads 1 and display 1, stream data, data driven mode.
        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(movieRepository.findAll(), 1);

        model.addAttribute("movies", reactiveDataDrivenMode);

        return "movie";

    }

    @GetMapping("/comments")
    public String commentsGetRequest(final Model model) {
        // loads 1 and display 1, stream data, data driven mode.
        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(commentRepository.findAll(), 1);

        model.addAttribute("comments", reactiveDataDrivenMode);
        return "comment";
    }

}