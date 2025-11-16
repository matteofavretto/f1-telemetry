package org.matteofavretto.controller;

import org.matteofavretto.model.Meeting;
import org.matteofavretto.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/meetings")
public class MeetingsController {

    @Autowired
    private MeetingService meetingService;

    @GetMapping("/meeting")
    public ResponseEntity<List<Meeting>> getMeeting(
            @ModelAttribute Meeting request
    )  {
        List<Meeting> response = meetingService.getMeeting(request);
        if (response.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(response);
    }
}
