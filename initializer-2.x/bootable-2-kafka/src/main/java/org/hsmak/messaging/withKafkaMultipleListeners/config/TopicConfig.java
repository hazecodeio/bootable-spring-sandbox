package org.hsmak.messaging.withKafkaMultipleListeners.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

    @Value(value = "${general.string.topic.name}")
    private String topicName;
    @Value(value = "${json.user.topic.name}")
    private String userTopicName;

    @Bean
    public NewTopic generalTopic() {
        return TopicBuilder
                .name(topicName)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic userTopic() {
        return TopicBuilder
                .name(userTopicName)
                .partitions(1)
                .replicas(1)
                .build();
    }
}