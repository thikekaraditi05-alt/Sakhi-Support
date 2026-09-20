package com.sakhi.support.dto;

import jakarta.validation.constraints.NotNull;

public class MentorshipRequestDto {

    @NotNull(message = "Mentee ID is required")
    private Long menteeId;

    @NotNull(message = "Mentor ID is required")
    private Long mentorId;

    private String message;

    public Long getMenteeId() { return menteeId; }
    public void setMenteeId(Long menteeId) { this.menteeId = menteeId; }

    public Long getMentorId() { return mentorId; }
    public void setMentorId(Long mentorId) { this.mentorId = mentorId; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}