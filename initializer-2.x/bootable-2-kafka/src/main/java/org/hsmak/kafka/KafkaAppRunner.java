package org.hsmak.kafka;

import org.hsmak.kafka.processors.KafkaProducers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.stream.IntStream;

/*
 * Link: https://docs.spring.io/spring-kafka/reference/html/
 */
@EnableKafka
@SpringBootApplication
public class KafkaAppRunner implements CommandLineRunner {

    @Autowired
    KafkaProducers kafkaProducers;

    public static void main(String[] args) {
        SpringApplication.run(KafkaAppRunner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        IntStream.range(0, 2)
                .forEach(i -> kafkaProducers.sendMessage("This is Spring Boot and Apache Kafka!!"));
    }
}
