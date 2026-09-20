package com.sakhi.support.controller;

import com.sakhi.support.dto.MentorshipRequestDto;
import com.sakhi.support.dto.MentorshipResponseDto;
import com.sakhi.support.service.MentorshipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mentorship")
public class MentorshipController {

    @Autowired
    private MentorshipService mentorshipService;

    @PostMapping("/request")
    public MentorshipResponseDto sendRequest(@Valid @RequestBody MentorshipRequestDto dto) {
        return mentorshipService.sendRequest(dto);
    }

    @GetMapping("/mentee/{menteeId}")
    public List<MentorshipResponseDto> getRequestsSentByMentee(@PathVariable Long menteeId) {
        return mentorshipService.getRequestsSentByMentee(menteeId);
    }

    @GetMapping("/mentor/{mentorId}")
    public List<MentorshipResponseDto> getRequestsForMentor(@PathVariable Long mentorId) {
        return mentorshipService.getRequestsForMentor(mentorId);
    }

    @PutMapping("/{requestId}/status")
    public MentorshipResponseDto updateStatus(@PathVariable Long requestId, @RequestParam String status) {
        return mentorshipService.updateStatus(requestId, status);
    }
}