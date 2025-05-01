package com.example.demo.service.Spotify;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Qualifier; // missing Qualifier import
import org.springframework.http.HttpHeaders; // missing HttpHeaders import

/////// UNDER WORK //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
@Service
public class SpotifyService {

    private final WebClient spotifyWebClient;
    private final SpotifyAuthService spotifyAuthService; // inject auth service

    public SpotifyService(@Qualifier("spotifyWebClient") WebClient spotifyWebClient,
                          SpotifyAuthService spotifyAuthService) {
        this.spotifyWebClient = spotifyWebClient;
        this.spotifyAuthService = spotifyAuthService;
    }

    public String searchAnything(String query) {
        String accessToken = spotifyAuthService.getAccessToken(); // get token properly

        return spotifyWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search")
                        .queryParam("q", query)
                        .queryParam("type", "track,album,artist")
                        .build())
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                .retrieve()
                .bodyToMono(String.class)
                .block(); // synchronous for simplicity
    }
/////// UNDER WORK //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}