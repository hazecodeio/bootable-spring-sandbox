package org.hsmak.messaging.withKafkaMultipleListeners.processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hsmak.messaging.withKafkaMultipleListeners.domain.User;
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
            topics = "${general.string.topic.name}",
            groupId = "${general.string.topic.group.id}",
            containerFactory = "kafkaListenerContainerFactory")
    public void consumeStringMsg(String message) {
        logger.info(String.format("String Message Received -> %s", message));
    }

    @KafkaListener(
            topics = "${json.user.topic.name}",
            groupId = "${json.user.topic.group.id}",
            containerFactory = "kafkaListenerContainerFactoryOfUser")
    public void consumeJsonUser(User user) {
        logger.info(String.format("Json User Received -> %s", user));
    }
}