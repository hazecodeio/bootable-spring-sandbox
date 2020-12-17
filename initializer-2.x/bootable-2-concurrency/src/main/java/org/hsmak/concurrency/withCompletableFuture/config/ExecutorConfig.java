package org.hsmak.concurrency.withCompletableFuture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ExecutorConfig {

    @Bean
    public ExecutorService ioBoundExecutor() {

        // Supplying a custom factor just to set a thread prefix name
        CustomizableThreadFactory threadFactory = new CustomizableThreadFactory("io-executor-id-");
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10, threadFactory);

        return fixedThreadPool;
    }

    @Bean
    public ExecutorService cpuBoundExecutor() {

        // Supplying a custom factor just to set a thread prefix name
        CustomizableThreadFactory threadFactory = new CustomizableThreadFactory("cpu-executor-id-");
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool(threadFactory);

        return cachedThreadPool;
    }
}