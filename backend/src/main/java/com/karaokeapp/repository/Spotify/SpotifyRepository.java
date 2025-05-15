package com.karaokeapp.repository.Spotify;

import com.karaokeapp.model.Session.Room;
import com.karaokeapp.model.Spotify.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SpotifyRepository {

    @Autowired
    private DynamoDbClient dynamoDbClient;

    private final String roomTable = "karaoke-rooms";
    private final String queueTable = "karaoke-queues";

    public String getSpotifyToken(String roomCode) {
        GetItemRequest request = GetItemRequest.builder()
                .tableName(roomTable)
                .key(Map.of("roomCode", AttributeValue.fromS(roomCode)))
                .build();

        Map<String, AttributeValue> item = dynamoDbClient.getItem(request).item();

        if (item != null && item.containsKey("spotifyToken")) {
            return item.get("spotifyToken").s();
        } else {
            return null; // or throw an exception if appropriate
        }
    }
//
//    public void queueTrack(Track track) {
//        Map<String, AttributeValue> item = new HashMap<>();
//        item.put("roomCode", AttributeValue.fromS(track.getRoomCode()));
//        item.put("trackID", AttributeValue.fromS(track.getTrackID()));
//        item.put("queuePosition", AttributeValue.fromN(String.valueOf(track.getQueuePosition())));
//        item.put("trackName", AttributeValue.fromS(track.getTrackName()));
//        item.put("trackCover", AttributeValue.fromS(track.getTrackCover()));
//        item.put("artistName", AttributeValue.fromS(track.getArtistName()));
//
//        PutItemRequest request = PutItemRequest.builder()
//                .tableName(queueTable)
//                .item(item)
//                .build();
//
//        dynamoDbClient.putItem(request);
//    }
}
