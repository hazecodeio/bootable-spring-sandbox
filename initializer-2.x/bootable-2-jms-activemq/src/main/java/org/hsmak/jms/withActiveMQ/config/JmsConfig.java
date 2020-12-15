package org.hsmak.jms.withActiveMQ.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@EnableJms
@Configuration
public class JmsConfig {

    @Value("${activemq.broker.url}")
    String brokerUrl;


    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerUrl);

        return activeMQConnectionFactory;
    }

    //######################### ListenerContainers ###########################//

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactoryOnQueue() {
        DefaultJmsListenerContainerFactory listenerContainerFactory = new DefaultJmsListenerContainerFactory();
        listenerContainerFactory.setConnectionFactory(connectionFactory());
        listenerContainerFactory.setMessageConverter(jacksonJmsMessageConverter());
        return listenerContainerFactory;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactoryOnTopic() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setMessageConverter(jacksonJmsMessageConverter());
        factory.setPubSubDomain(true); // Change to Topic/pub-sub instead of Queue/Point-To-Point
        return factory;
    }

    //######################### MessageConverters ###########################//

    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type"); // ToDo: what is this for?
        return converter;
    }

    //######################### JmsTemplates ###########################//
    @Bean
    public JmsTemplate jmsTemplateOnQueue(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName("queue/mailbox");
        template.setDefaultDestination(new ActiveMQQueue("queue/mailbox"));
        template.setMessageConverter(jacksonJmsMessageConverter());
        return template;
    }

    @Bean
    public JmsTemplate jmsTemplateOnTopic(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName("topic/mailbox");
        template.setDefaultDestination(new ActiveMQTopic("topic/mailbox"));
        template.setMessageConverter(jacksonJmsMessageConverter());
        return template;
    }
}

//###################### Below is way to replace the @JmsListener ###################//

/*
 * Links:
 *      - https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#jms-annotated-programmatic-registration
 *      - https://stackoverflow.com/questions/34063230/adding-dynamic-number-of-listenersspring-jms
 */
//@Configuration
class AppConfig implements JmsListenerConfigurer {

    @Override
    public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
        SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
        endpoint.setId("myJmsEndpoint");
        endpoint.setDestination("anotherQueue");
        endpoint.setMessageListener(message -> {
            // processing
        });

        registrar.registerEndpoint(endpoint);
    }
}