package com.karaokeapp.service.Spotify;

import com.karaokeapp.model.Spotify.Track;
import com.karaokeapp.repository.Spotify.SpotifyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Qualifier; // missing Qualifier import
import org.springframework.http.HttpHeaders; // missing HttpHeaders import

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/////// UNDER WORK //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
@Service
public class SpotifyService {

    private final WebClient spotifyWebClient;
    private final SpotifyRepository spotifyRepository; // inject auth service
    private final ObjectMapper objectMapper = new ObjectMapper();

    public SpotifyService(@Qualifier("spotifyWebClient") WebClient spotifyWebClient,
                          SpotifyRepository spotifyRepository) {
        this.spotifyWebClient = spotifyWebClient;
        this.spotifyRepository = spotifyRepository;
    }

    public String searchAnything(String query, String roomCode) {
        String accessToken = spotifyRepository.getSpotifyToken(roomCode); // get token properly

        return spotifyWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search")
                        .queryParam("q", query)
                        .queryParam("type", "track")
                        .queryParam("limit", "9")
                        .build())
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                .retrieve()
                .bodyToMono(String.class)
                .block(); // synchronous for simplicity
    }

    public List<String> getTrackName(String query, String roomCode) {
        try {
            String response = searchAnything(query, roomCode);
            JsonNode root = objectMapper.readTree(response);
            JsonNode items = root.path("tracks").path("items");

            List<String> trackNames = new ArrayList<>();
            for (JsonNode item : items) {
                trackNames.add(item.path("name").asText());
            }

            return trackNames;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }// get token properly
    }

    public List<String> getTrackCover(String query, String roomCode) {
        try {
            String response = searchAnything(query, roomCode);
            JsonNode root = objectMapper.readTree(response);
            JsonNode items = root.path("tracks").path("items");

            List<String> trackCovers = new ArrayList<>();
            for (JsonNode item : items) {
                JsonNode images = item.path("album").path("images");
                if (images.isArray() && images.size() > 0) {
                    trackCovers.add(images.get(0).path("url").asText());
                }
            }

            return trackCovers;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }// get token properly
    }

    public List<String> getTrackArtist(String query, String roomCode) {
        try {
            String response = searchAnything(query, roomCode);
            JsonNode root = objectMapper.readTree(response);
            JsonNode items = root.path("tracks").path("items");

            List<String> artistNames = new ArrayList<>();
            for (JsonNode item : items) {
                JsonNode artists = item.path("artists");
                if (artists.isArray() && artists.size() > 0) {
                    artistNames.add(artists.get(0).path("name").asText());
                }
            }

            return artistNames;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

/////// UNDER WORK //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}