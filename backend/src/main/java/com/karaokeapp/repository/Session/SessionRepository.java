package com.karaokeapp.repository.Session;

import com.karaokeapp.model.Session.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SessionRepository {

    @Autowired
    private DynamoDbClient dynamoDbClient;

    private final String roomTable = "karaoke-rooms";

    public void saveRoom(Room room) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("roomCode", AttributeValue.fromS(room.getRoomCode()));
        item.put("users", AttributeValue.fromL(room.getUsers().stream()
                .map(AttributeValue::fromS)
                .collect(Collectors.toList())));
        item.put("utc", AttributeValue.fromS(room.getUTC().toString()));
        item.put("expiresAt", AttributeValue.fromN(String.valueOf(room.getExpiresAt())));
        item.put("spotifyToken", AttributeValue.fromS(room.getSpotifyToken()));

        PutItemRequest request = PutItemRequest.builder()
                .tableName(roomTable)
                .item(item)
                .build();

        dynamoDbClient.putItem(request);
    }
/////// UNDER WORK //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addTime(String roomCode, long expiresAt, String spotifyToken, Instant utc) {
        GetItemRequest request = GetItemRequest.builder()
                .tableName(roomTable)
                .key(Map.of("roomCode", AttributeValue.fromS(roomCode)))
                .build();

        dynamoDbClient.getItem(request).hasItem();
    }
/////// UNDER WORK //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean roomExists(String roomCode) {
        GetItemRequest request = GetItemRequest.builder()
                .tableName(roomTable)
                .key(Map.of("roomCode", AttributeValue.fromS(roomCode)))
                .build();

        return dynamoDbClient.getItem(request).hasItem();
    }
/////// UNDER WORK //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void deleteRoom(String roomCode) {
        DeleteItemRequest request = DeleteItemRequest.builder()
                .tableName(roomTable)
                .key(Map.of("roomCode", AttributeValue.fromS(roomCode)))
                .build();

        dynamoDbClient.deleteItem(request);
    }
/////// UNDER WORK //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}