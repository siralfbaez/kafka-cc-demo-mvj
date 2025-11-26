package com.urme.kafka_cc_demo_mvj25;

import java.time.Instant;

// Using a Java Record (available since Java 16/17+)
public record CloudMessage(
        String id,
        String content,
        Instant timestamp
) {}