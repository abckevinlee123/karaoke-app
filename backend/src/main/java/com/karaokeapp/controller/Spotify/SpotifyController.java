package com.karaokeapp.controller.Spotify;

import com.karaokeapp.service.Spotify.SpotifyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
public class SpotifyController {

    private final SpotifyService spotifyService; // fixed the type and variable name

    public SpotifyController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

//    @GetMapping("/search-anything")
//    public String searchAnything(@RequestParam String query, String roomCode) {
//        return spotifyService.searchAnything(query, roomCode); // fixed the call
//    }

    @GetMapping("/get-track-name")
    public List<String> getTrackName(@RequestParam String query, String roomCode) {
        return spotifyService.getTrackName(query, roomCode); // fixed the call
    }

    @GetMapping("/get-track-cover")
    public List<String> returnTrackCover(@RequestParam String query, String roomCode) {
        return spotifyService.getTrackCover(query, roomCode); // fixed the call
    }

    @GetMapping("/get-track-artist")
    public List<String> getTrackArtist(@RequestParam String query, String roomCode) {
        return spotifyService.getTrackArtist(query, roomCode); // fixed the call
    }
}