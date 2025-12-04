package com.urme.kafka_cc_demo_mvj25;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class KafkaCcDemoMvj25Application {

	public static void main(String[] args) {
		SpringApplication.run(KafkaCcDemoMvj25Application.class, args);
	}

}
