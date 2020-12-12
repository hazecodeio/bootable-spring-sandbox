package org.hsmak.reactive.repository;

import org.hsmak.reactive.entity.Comment;
import reactor.core.publisher.Flux;

public interface CommentRepository {
    Flux<Comment> findAll();
}
