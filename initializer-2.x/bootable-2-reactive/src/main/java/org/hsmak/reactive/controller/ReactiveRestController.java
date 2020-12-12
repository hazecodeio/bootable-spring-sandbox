package org.hsmak.reactive.controller;

import org.hsmak.reactive.entity.Comment;
import org.hsmak.reactive.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ReactiveRestController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "/comments/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Comment> feed() {
        return this.commentRepository.findAll();
    }

}