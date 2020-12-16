package org.hsmak.kafka.processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    private static Logger logger = LogManager.getLogger(KafkaListeners.class);

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
