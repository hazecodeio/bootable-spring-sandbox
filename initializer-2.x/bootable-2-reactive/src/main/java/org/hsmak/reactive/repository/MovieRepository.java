package org.hsmak.reactive.repository;

import org.hsmak.reactive.entity.Movie;
import reactor.core.publisher.Flux;

public interface MovieRepository {
    Flux<Movie> findAll();
}
