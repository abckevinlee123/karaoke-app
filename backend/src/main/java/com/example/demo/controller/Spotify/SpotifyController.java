package com.example.demo.controller.Spotify;

import com.example.demo.service.Spotify.SpotifyService;
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
    public String searchAnything(@RequestParam String query) {
        return spotifyService.searchAnything(query); // fixed the call
    }
}