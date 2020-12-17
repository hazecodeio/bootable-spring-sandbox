package org.hsmak.concurrency.withCompletableFuture;

import org.hsmak.concurrency.withCompletableFuture.service.CompletableFutureOps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class AppRunnerOfCompletableFuture implements CommandLineRunner {

    @Autowired
    CompletableFutureOps completableFutureOps;

    public static void main(String[] args) {
        SpringApplication.run(AppRunnerOfCompletableFuture.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(Thread.currentThread().getName() + ": Calling AsyncCalls...");

        completableFutureOps.asyncFlow("This is A Man In the Wood", null, null);

        System.out.println(Thread.currentThread().getName() + ": AsyncCalls have been dispatched...");
        System.out.println(Thread.currentThread().getName() + ": Do some other time consuming tasks...");

        System.out.println(Thread.currentThread().getName() + ": Main thread is joining...");


        System.out.println(Thread.currentThread().getName() + ": Main thread after Joining...");

    }
}

