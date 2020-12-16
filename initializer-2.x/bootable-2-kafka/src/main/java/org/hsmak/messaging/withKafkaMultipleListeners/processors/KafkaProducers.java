package org.hsmak.messaging.withKafkaMultipleListeners.processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hsmak.messaging.withKafkaMultipleListeners.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaProducers {

    private static final Logger logger = LogManager.getLogger(KafkaProducers.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplateOfString;
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplateOfJsonUser;

    @Value(value = "${general.string.topic.name}")
    private String topicName;
    @Value(value = "${json.user.topic.name}")
    private String userTopicName;


    public void sendMessage(String message) {
        ListenableFuture<SendResult<String, String>> future = this.kafkaTemplateOfString.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info(
                        "String Message Sent: "
                                + message
                                + " with offset: "
                                + result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.error("Unable to send String Message : " + message, ex);
            }
        });
    }

    public void sendUser(User user) {
        ListenableFuture<SendResult<String, User>> future = this.kafkaTemplateOfJsonUser.send(userTopicName, user);

        future.addCallback(new ListenableFutureCallback<SendResult<String, User>>() {
            @Override
            public void onSuccess(SendResult<String, User> result) {
                logger.info(
                        "Json User Sent: "
                                + user
                                + " with offset: "
                                + result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.error("Unable to send Json User: " + user, ex);
            }
        });
    }
}