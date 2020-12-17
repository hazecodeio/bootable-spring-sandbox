package org.hsmak.concurrency.withSpringAsync.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@Service
public class AsyncOps {

    /*
     * Observations:
     *      - Spring’s @Async annotation indicates that it should run on a separate thread.
     *      - The method’s return type is CompletableFuture<R>; a requirement for any asynchronous service.
     */
    @Async
    public <T, R> CompletableFuture<R> callAsyncWithDelay(T input,
                                                          Function<T, R> transform,
                                                          Duration duration) throws InterruptedException {

        System.out.println(Thread.currentThread().getName() + ": Before Sleep");
        Thread.sleep(duration.toMillis());
        System.out.println(Thread.currentThread().getName() + ": After Sleep");

        CompletableFuture<R> completedFuture = CompletableFuture.completedFuture(transform.apply(input));
        return completedFuture;
    }
}
