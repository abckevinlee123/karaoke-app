package com.example.demo.controller.Session;

import com.example.demo.service.Session.SessionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Missing functionality:
// - Add time after 1 hour session (messy looking code)
// - Users (web sockets)
// - Deleting room after everyone has left

@Controller
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping("/create-room")
    public ResponseEntity<String> createRoom() {
        String newSession = sessionService.createRoom();
        return ResponseEntity.ok(newSession);
    }

    @GetMapping("/join-room")
    public ResponseEntity<String> joinRoom(@RequestParam String roomCode) {
        if (!sessionService.joinRoom(roomCode)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room does not exist.");
        }
        return ResponseEntity.ok(roomCode); // Return the room code to frontend
    }
}
