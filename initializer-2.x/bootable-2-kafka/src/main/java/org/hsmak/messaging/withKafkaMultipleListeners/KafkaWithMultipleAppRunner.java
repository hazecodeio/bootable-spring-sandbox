package org.hsmak.messaging.withKafkaMultipleListeners;

import org.hsmak.messaging.withKafkaMultipleListeners.domain.User;
import org.hsmak.messaging.withKafkaMultipleListeners.processors.KafkaProducers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.UUID;
import java.util.stream.IntStream;


@EnableKafka
@SpringBootApplication
public class KafkaWithMultipleAppRunner implements CommandLineRunner {

    @Autowired
    KafkaProducers kafkaProducers;

    public static void main(String[] args) {
        SpringApplication.run(KafkaWithMultipleAppRunner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        kafkaProducers.sendMessage("This is a String Msg");
        IntStream.range(0, 2).forEach(i -> kafkaProducers.sendUser(new User(UUID.randomUUID().getLeastSignificantBits(), "James", "Baldwin")));
    }
}
