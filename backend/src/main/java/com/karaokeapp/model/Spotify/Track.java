package com.karaokeapp.model.Spotify;

public class Track {
    private String roomCode;
    private String trackID;
    private float queuePosition;
    private String trackName;
    private String trackCover;
    private String artistName;


    public Track(String roomCode, String trackID, float queuePosition, String trackName, String trackCover, String artistName ) {
        this.roomCode = roomCode;
        this.trackID = trackID;
        this.queuePosition = queuePosition;
        this.trackName = trackName;
        this.trackCover = trackCover;
        this.artistName = artistName;
    }

    public String getRoomCode() { return roomCode; }
    public String getTrackID() { return trackID; }
    public float getQueuePosition() { return queuePosition; }
    public String getTrackName() { return trackName; }
    public String getTrackCover() { return trackCover; }
    public String getArtistName() { return artistName; }

}
