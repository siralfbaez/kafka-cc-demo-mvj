package com.urme.kafka_cc_demo_mvj25;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;

public record CloudMessage(
        String id,
        String content,
        Instant timestamp
) {
    @JsonCreator
    public static CloudMessage create( // Changed to static method 'create'
                                       @JsonProperty("id") String id,
                                       @JsonProperty("content") String content,
                                       @JsonProperty("timestamp") Instant timestamp) {

        // This calls the implicit Record constructor to build the final object
        return new CloudMessage(id, content, timestamp);
    }
}