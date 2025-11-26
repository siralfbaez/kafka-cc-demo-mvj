package com.urme.kafka_cc_demo_mvj25.producer;

import com.urme.kafka_cc_demo_mvj25.CloudMessage;
// import com.urme.urme_cc_kafka_producer_consumer_mvj25.CloudMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

    // Topic name is injected from application.properties
    @Value("${app.kafka.topic-name}")
    private String topicName;

    // The KafkaTemplate is typed to send String keys and CloudMessage values
    private final KafkaTemplate<String, CloudMessage> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, CloudMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(CloudMessage message) {
        LOGGER.info("Producer sending structured message with content: '{}' to topic '{}'", message.content(), topicName);

        // Key is optional; we are sending the message object as the value
        kafkaTemplate.send(topicName, message);
    }
}