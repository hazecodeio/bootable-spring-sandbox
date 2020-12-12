package org.hsmak.reactive.withR2DBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories("org.hsmak.reactive.repository")
public class ReactiveWithR2DBCAppRunner {
    public static void main(String[] args) {
        SpringApplication.run(ReactiveWithR2DBCAppRunner.class, args);
    }
}