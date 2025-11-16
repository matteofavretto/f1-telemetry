package org.matteofavretto.controller;

import org.matteofavretto.model.Meeting;
import org.matteofavretto.model.Session;
import org.matteofavretto.model.SessionResult;
import org.matteofavretto.service.MeetingService;
import org.matteofavretto.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("/session")
    public ResponseEntity<List<Session>> getSession(
            @RequestParam String sessionKey
    )  {
        List<Session> response = sessionService.getSession(sessionKey);
        if (response == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/result")
    public ResponseEntity<List<SessionResult>> getSessionResult(
            @RequestParam String sessionKey
    )  {
        List<SessionResult> response = sessionService.getSessionResult(sessionKey);
        if (response.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/races")
    public ResponseEntity<List<Session>> getRacesByYear(
            @RequestParam int year
    )  {
        List<Session> response = sessionService.getRacesByYear(year);
        if (response.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(response);
    }
}
