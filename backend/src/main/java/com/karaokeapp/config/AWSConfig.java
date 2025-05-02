package com.karaokeapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;

@Configuration
public class AWSConfig {

    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.builder()
                .region(Region.US_EAST_2)  // Specify your region here
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();
    }
}