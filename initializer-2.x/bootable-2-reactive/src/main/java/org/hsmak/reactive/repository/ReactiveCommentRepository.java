package org.hsmak.reactive.repository;

import org.hsmak.reactive.entity.Comment;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Repository
public class ReactiveCommentRepository implements CommentRepository {

    @Override
    public Flux<Comment> findAll() {
        //simulate data streaming every 1 second.
        return Flux.interval(Duration.ofSeconds(1))
                .onBackpressureDrop()
                .flatMapIterable(x -> generateComment());
    }

    private List<Comment> generateComment() {
        Comment comment = new Comment(
                randomAuthor(),
                randomMessage(),
                getCurrentTimeStamp());
        return List.of(comment);
    }
}

class CommentGenerator {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    private static final List<String> COMMENT_AUTHOR =
            List.of(
                    "Midge", "Alice", "Jack", "Lenny", "Jacob",
                    "Rachael", "Emily", "John", "Rose", "Isabella");

    private static final List<String> COMMENT_MESSAGE =
            List.of(
                    "I Love this!",
                    "Me too!",
                    "Wow",
                    "True!",
                    "Hello everyone here?",
                    "Good!");

    public static String randomAuthor() {
        return COMMENT_AUTHOR.get(RANDOM.nextInt(COMMENT_AUTHOR.size()));
    }

    public static String randomMessage() {
        return COMMENT_MESSAGE.get(RANDOM.nextInt(COMMENT_MESSAGE.size()));
    }

    public static String getCurrentTimeStamp() {
        return DATE_TIME_FORMATTER.format(LocalDateTime.now());
    }
}