package org.hsmak.concurrency.withSpringAsync;

import org.hsmak.concurrency.withSpringAsync.service.AsyncOps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableAsync
public class AppRunnerOfSpringAsync implements CommandLineRunner {

    @Autowired
    AsyncOps asyncOps;

    public static void main(String[] args) {
        SpringApplication.run(AppRunnerOfSpringAsync.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(Thread.currentThread().getName() + ": Calling AsyncCalls...");

        CompletableFuture<String> f1 = asyncOps.callAsyncWithDelay(
                "Some Input1",
                s -> s.toUpperCase(),
                Duration.ofSeconds(ThreadLocalRandom.current().nextInt(3)));

        CompletableFuture<String> f2 = asyncOps.callAsyncWithDelay(
                "Some Input2",
                s -> s.toLowerCase(),
                Duration.ofSeconds(ThreadLocalRandom.current().nextInt(3)));

        CompletableFuture<String> f3 = asyncOps.callAsyncWithDelay(
                "Some Input3",
                s -> s.concat("_Concatenated"),
                Duration.ofSeconds(ThreadLocalRandom.current().nextInt(3)));

        System.out.println(Thread.currentThread().getName() + ": AsyncCalls have been dispatched...");
        System.out.println(Thread.currentThread().getName() + ": Do some other time consuming tasks...");

        System.out.println(Thread.currentThread().getName() + ": Main thread is joining...");

        //CompletableFuture.allOf(f1, f2, f3).join();
        CompletableFuture[] cfs = {f1, f2, f3};
        CompletableFuture.allOf(cfs).join(); //blocking

        System.out.println(Thread.currentThread().getName() + ": Main thread after Joining...");

        for (CompletableFuture cf : cfs) {

            /*
             * cf.get() is another blocking call.
             * However, because MainThread has already joined, results are already fetched and ready to be retrieved.
             */
            System.out.println(Thread.currentThread().getName() + ": " + cf.get());
        }
    }
}

