package org.hsmak.jms.withActiveMQ.processors;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hsmak.jms.withActiveMQ.domain.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producers {

    private static Logger logger = LogManager.getLogger(Producers.class);
    @Autowired
    JmsTemplate jmsTemplateOnQueue;
    @Autowired
    JmsTemplate jmsTemplateOnTopic;

    public void send(Email email) {

        logger.info("Sending an email message.");

        // Though JmsTemplate has the Destination already set by default, it can be overridden here!
        jmsTemplateOnQueue.convertAndSend(
                new ActiveMQQueue("queue/mailbox"),
//                "queue/mailbox", // Defaulting to Queue
                email);
    }

    public void publish(Email email) {

        logger.info("Publishing an email message to all subscribers.");

        // Though JmsTemplate has the Destination already set by default, it can be overridden here!
        jmsTemplateOnTopic.convertAndSend(
                new ActiveMQTopic("topic/mailbox"),
//                "topic/mailbox", // Passing a plain String doesn't work with Topics since the default is a Queue
                email);
    }
}
