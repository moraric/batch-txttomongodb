package com.example.batchtxttomongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableBatchProcessing
@EnableMongoRepositories(basePackages = "com.example.batchtxttomongodb.repository")
public class BatchtxttomongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchtxttomongodbApplication.class, args);
	}

}
