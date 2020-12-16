package org.hsmak;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FutureAppRunner implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FutureAppRunner.class, "Hello World!");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(args[0]);
    }
}
