package com.karaokeapp.controller.Spotify;

import com.karaokeapp.service.Spotify.SpotifyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class SpotifyController {

    private final SpotifyService spotifyService; // fixed the type and variable name

    public SpotifyController (SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    @GetMapping("/search-anything")
    public String searchAnything(@RequestParam String query, String roomCode) {
        return spotifyService.searchAnything(query, roomCode); // fixed the call
    }
}