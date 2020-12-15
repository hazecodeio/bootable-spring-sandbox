package org.hsmak.jms.withActiveMQ.processors;

import org.hsmak.jms.withActiveMQ.domain.Email;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumers {


    @JmsListener(
            destination = "queue/mailbox",
            containerFactory = "jmsListenerContainerFactoryOnQueue")
    public void listenOnQueue(Email email) {
        System.out.println("Received from queue <" + email + ">");
    }

    @JmsListener(
            destination = "queue/mailbox",
            containerFactory = "jmsListenerContainerFactoryOnQueue")
    public void listen2OnQueue(Email email) {
        System.out.println("Received2 from queue <" + email + ">");
    }

    @JmsListener(
            destination = "topic/mailbox",
            containerFactory = "jmsListenerContainerFactoryOnTopic")
    public void listenOnTopic(Email email) {
        System.out.println("Received from topic<" + email + ">");
    }

    @JmsListener(
            destination = "topic/mailbox",
            containerFactory = "jmsListenerContainerFactoryOnTopic")
    public void listen2OnTopic(Email email) {
        System.out.println("Received2 from topic<" + email + ">");
    }
}