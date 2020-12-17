package org.hsmak.concurrency.withCompletableFuture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CompletableFutureOps {

    @Autowired
    ExecutorService ioBoundExecutor;

    @Autowired
    ExecutorService cpuBoundExecutor;

    public CompletableFuture<Void> asyncFlow(String input,
                                             Function<String, String> transform,
                                             Duration duration) throws InterruptedException {

        System.out.println(Thread.currentThread().getName() + ": Before Sleep");
//        Thread.sleep(Duration.ofSeconds(2).toMillis());
        System.out.println(Thread.currentThread().getName() + ": After Sleep");

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ": SupplyAsync");
            return input.toLowerCase();

        }, cpuBoundExecutor)
                .thenApply(s -> {

                    System.out.println(Thread.currentThread().getName() + ": ThenApply1");
                    return s.chars().mapToObj(c -> (char) c).filter(c -> !Set.of('a', 'e', 'i', 'o', 'u').contains(c)).collect(Collectors.toList());

                })
                .thenApply(l -> {

                    System.out.println(Thread.currentThread().getName() + ": ThenApply2");
                    return l.stream().map(String::valueOf).collect(Collectors.joining());

                })
                .thenAccept(System.out::println);

        System.out.println("After.................................");

        return voidCompletableFuture;
    }
    /*
     * Chaining/Composing CompletableFutures <- similar to composing Flux/Mono
     *
     * Patterns used in CompletableFuture API:
     *      apply    -> takes a Function
     *      supply   -> takes a Supplier
     *      accept   -> takes a Consumer
     *      run      -> takes a Runnable
     *
     *      then
     *      either
     *      both
     *      combine
     *
     *      w/out async
     */
}
