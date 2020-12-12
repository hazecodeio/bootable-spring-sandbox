package org.hsmak.reactive.repository;

import org.hsmak.reactive.entity.Movie;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Repository
public class MovieRepositoryImp implements MovieRepository {

    private final List<Movie> movies = List.of(
            new Movie("Polar (2019)", 64),
            new Movie("Iron Man (2008)", 79),
            new Movie("The Shawshank Redemption (1994)", 93),
            new Movie("Forrest Gump (1994)", 83),
            new Movie("Glass (2019)", 70)
    );

    @Override
    public Flux<Movie> findAll() {
        // Stream data with 1 second delay.
        return Flux.fromIterable(movies)
                .delayElements(Duration.ofSeconds(1));

        // Nonstop & Repeatedly, Stream the whole List every 2 second
        /*return Flux.interval(Duration.ofSeconds(2))
                .onBackpressureDrop()
                .map(x -> movie)
                .flatMapIterable(x -> x);*/
    }

}
