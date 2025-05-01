package com.example.demo.repository.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;

import java.util.Map;

@Service
public class SpotifyRepository {

    @Autowired
    private DynamoDbClient dynamoDbClient;

    private final String tableName = "karaoke-rooms";

    public String spotifyTokenRetrieve(String roomCode) {
        GetItemRequest request = GetItemRequest.builder()
                .tableName(tableName)
                .key(Map.of("roomCode", AttributeValue.fromS(roomCode)))
                .build();

        Map<String, AttributeValue> item = dynamoDbClient.getItem(request).item();

        if (item != null && item.containsKey("spotifyToken")) {
            return item.get("spotifyToken").s();
        } else {
            return null; // or throw an exception if appropriate
        }
    }
}
