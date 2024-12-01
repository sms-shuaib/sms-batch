package com.example.batch.processing.sms_batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableBatchProcessing
public class SmsBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsBatchApplication.class, args);
	}

}
