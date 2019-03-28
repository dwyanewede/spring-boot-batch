package com.sxs.spring.boot.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class BatchjobApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchjobApplication.class, args);
	}
}
