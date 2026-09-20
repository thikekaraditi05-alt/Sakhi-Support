package com.sakhi.support.dto;

import java.time.LocalDateTime;

public class MentorshipResponseDto {

    private Long id;
    private Long menteeId;
    private String menteeName;
    private Long mentorId;
    private String mentorName;
    private String message;
    private String status;
    private LocalDateTime createdAt;

    public MentorshipResponseDto() {}

    public MentorshipResponseDto(Long id, Long menteeId, String menteeName, Long mentorId,
                                  String mentorName, String message, String status, LocalDateTime createdAt) {
        this.id = id;
        this.menteeId = menteeId;
        this.menteeName = menteeName;
        this.mentorId = mentorId;
        this.mentorName = mentorName;
        this.message = message;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getMenteeId() { return menteeId; }
    public void setMenteeId(Long menteeId) { this.menteeId = menteeId; }

    public String getMenteeName() { return menteeName; }
    public void setMenteeName(String menteeName) { this.menteeName = menteeName; }

    public Long getMentorId() { return mentorId; }
    public void setMentorId(Long mentorId) { this.mentorId = mentorId; }

    public String getMentorName() { return mentorName; }
    public void setMentorName(String mentorName) { this.mentorName = mentorName; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}