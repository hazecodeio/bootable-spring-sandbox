package org.hsmak.messaging.withKafkaSimple.processors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducers {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
//        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("MyTopic", msg);
        kafkaTemplate.send("MyTopic", msg);
    }
}
