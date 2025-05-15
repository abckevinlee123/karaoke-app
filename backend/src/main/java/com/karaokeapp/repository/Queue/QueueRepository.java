package com.karaokeapp.repository.Queue;

import com.karaokeapp.model.Spotify.Track;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

import java.util.HashMap;
import java.util.Map;

public class QueueRepository {
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
