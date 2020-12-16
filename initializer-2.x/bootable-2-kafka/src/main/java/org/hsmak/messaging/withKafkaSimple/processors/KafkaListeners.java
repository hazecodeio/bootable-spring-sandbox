package org.hsmak.messaging.withKafkaSimple.processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/*
 *  Observations:
 *      - Listeners of different groupId will receive a duplicate message/record from the topic; more of broadcasting
 *      - Listeners of the same groupId will receive a unique message/record
 */
@Component
public class KafkaListeners {

    private static final Logger logger = LogManager.getLogger(KafkaListeners.class);

    @KafkaListener(
            topics = "MyTopic",
            groupId = "group-x",
            containerFactory = "kafkaListenerContainerFactory")
    public void listen(String message) {
        logger.info("Received Message in group - group-x: {}", message);
    }

    @KafkaListener(
            topics = "MyTopic",
            groupId = "group-y",
            containerFactory = "kafkaListenerContainerFactory")
    public void listen2(String message) {
        logger.info("Received2 Message in group - group-y: {}", message);
    }
}
