package com.karaokeapp.model.Session;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

// Room: Representative of a karaoke room. You have a room code (room number) for users to identify and join,
// a list of users for the logistics, and a list of songs as well for logistics

public class Room {
    private String roomCode;
    private List<String> users;
    private Instant utc;
    private long expiresAt;
    private String spotifyToken;
    private int hour = 3600; // default 1 hour

    public Room(String roomCode, String spotifyToken) {
        this.roomCode = roomCode;
        this.users = new ArrayList<>();
        this.utc = Instant.now().plusSeconds(hour);
        this.expiresAt = utc.getEpochSecond();
        this.spotifyToken = spotifyToken;
    }

    // Getters
    public String getRoomCode() { return roomCode; }
    public List<String> getUsers() { return users; }
    public Instant getUTC() { return utc; }
    public long getExpiresAt() { return expiresAt; }
    public String getSpotifyToken() { return spotifyToken; }

    // Setters
    public void setExpiresAt() {
        this.utc = Instant.now().plusSeconds(hour);
        this.expiresAt = utc.getEpochSecond();
    }
    public void setSpotifyToken(String newSpotifyToken) {
        this.spotifyToken = newSpotifyToken;
    }
}
