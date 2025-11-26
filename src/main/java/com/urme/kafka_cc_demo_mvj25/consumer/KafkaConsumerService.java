package com.urme.kafka_cc_demo_mvj25.consumer;
// package com.urme.urme_cc_kafka_producer_consumer_mvj25.consumer;

import com.urme.kafka_cc_demo_mvj25.CloudMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);

    // The consumer automatically listens to the topic name and group ID
    // defined in application.properties.
    // The value received is automatically deserialized into a CloudMessage object.
    @KafkaListener(topics = "${app.kafka.topic-name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeJsonMessage(CloudMessage message) {

        LOGGER.info("Consumer received structured message:");
        LOGGER.info("  ID: {}", message.id());
        LOGGER.info("  Content: {}", message.content());
        LOGGER.info("  Timestamp: {}", message.timestamp());
    }
}