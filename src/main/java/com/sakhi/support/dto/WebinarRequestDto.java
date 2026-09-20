package com.sakhi.support.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class WebinarRequestDto {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;
    private String speakerName;
    private LocalDateTime scheduledDate;
    private String link;
    private String category;

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