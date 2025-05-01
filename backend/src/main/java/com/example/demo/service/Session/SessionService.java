package com.example.demo.service.Session;

import com.example.demo.repository.Session.SessionRepository;
import com.example.demo.service.Spotify.SpotifyAuthService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.model.Session.Room;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Instant;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

// Session Service: The "ticketing system" for generating available rooms and directing users to the
// right rooms. roomMap is the data that goes into the room. On creation, it will look something like this:
// roomCode (028421)
// newRoom ([028421], [], [])
// roomMap ([[028421], [[028421], [], []]])

@Service
public class SessionService {

    private Map<String, Room> roomMap = new HashMap<>();

    private final SpotifyAuthService spotifyAuthService; //Spotify API Auth logic
    private final SessionRepository sessionRepository;

    public SessionService(SpotifyAuthService spotifyAuthService, SessionRepository sessionRepository) {
        this.spotifyAuthService = spotifyAuthService;
        this.sessionRepository = sessionRepository;
    }

    public String createRoom() {
        //Generate room code and spotify token (1hr)
        String roomCode = generateRoomCode();
        String spotifyToken = spotifyAuthService.getAccessToken(); // get token properly

        //Place room code and spotify token
        Room newRoom = new Room(roomCode, spotifyToken);
        sessionRepository.saveRoom(newRoom);

        roomMap.put(roomCode, newRoom);
        return roomCode;
    }
/////// UNDER WORK //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    public void addTime(String roomCode, long expiresAt, String spotifyToken, Instant utc) {
//        sessionRepository.addTime(roomCode, expiresAt, spotifyToken, utc)
//    }
/////// UNDER WORK //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean joinRoom(String roomCode) {
        return sessionRepository.roomExists(roomCode);
    }

/////// UNDER WORK //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    public void deleteRoom() {
//        Used for when the users all leave, utilize websockets
//    }
/////// UNDER WORK //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private String generateRoomCode() {
        // Simple random string generator for the room code
        String generatedCode;
        do {
            generatedCode = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        } while (sessionRepository.roomExists(generatedCode));
        return generatedCode;
    }
}
