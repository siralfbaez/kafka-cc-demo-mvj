package com.urme.kafka_cc_demo_mvj25.controller;
// package com.urme.urme_cc_kafka_producer_consumer_mvj25.controller;

import com.urme.kafka_cc_demo_mvj25.CloudMessage;
import com.urme.kafka_cc_demo_mvj25.producer.KafkaProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    private final KafkaProducerService producerService;

    public KafkaController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/publish")
    public String publishMessage(@RequestBody CloudMessage message) {
        producerService.sendMessage(message);
        return "Message with ID '" + message.id() + "' sent to Kafka topic!";
    }
}