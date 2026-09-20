package com.sakhi.support.dto;

import java.time.LocalDateTime;

public class WebinarResponseDto {

    private Long id;
    private String title;
    private String description;
    private String speakerName;
    private LocalDateTime scheduledDate;
    private String link;
    private String category;

    public WebinarResponseDto() {}

    public WebinarResponseDto(Long id, String title, String description, String speakerName,
                               LocalDateTime scheduledDate, String link, String category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.speakerName = speakerName;
        this.scheduledDate = scheduledDate;
        this.link = link;
        this.category = category;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSpeakerName() { return speakerName; }
    public void setSpeakerName(String speakerName) { this.speakerName = speakerName; }

    public LocalDateTime getScheduledDate() { return scheduledDate; }
    public void setScheduledDate(LocalDateTime scheduledDate) { this.scheduledDate = scheduledDate; }

    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}