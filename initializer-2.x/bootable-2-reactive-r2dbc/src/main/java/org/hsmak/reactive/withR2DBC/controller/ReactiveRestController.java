package org.hsmak.reactive.withR2DBC.controller;

import org.hsmak.reactive.withR2DBC.entity.Customer;
import org.hsmak.reactive.withR2DBC.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class ReactiveRestController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(path = "/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomers() {
        return this.customerRepository
                .findAll()
                .delayElements(Duration.ofSeconds(1));
    }
}