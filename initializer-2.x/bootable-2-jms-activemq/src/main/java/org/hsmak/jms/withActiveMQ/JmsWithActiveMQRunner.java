package org.hsmak.jms.withActiveMQ;

import org.hsmak.jms.withActiveMQ.domain.Email;
import org.hsmak.jms.withActiveMQ.processors.Producers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class JmsWithActiveMQRunner implements CommandLineRunner {

    @Autowired
    Producers producers;

    public static void main(String[] args) {
        SpringApplication.run(JmsWithActiveMQRunner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Send a message with a POJO - the template reuse the message converter
        System.out.println("Calling Sender to send an email message.");
        producers.send(new Email("info@example.com", "Hello"));
        producers.publish(new Email("publish@HHHHHH.com", "Has been broadcast!!!"));
    }
}