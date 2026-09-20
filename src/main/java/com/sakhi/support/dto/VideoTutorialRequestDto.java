package com.sakhi.support.dto;

import jakarta.validation.constraints.NotBlank;

public class VideoTutorialRequestDto {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;
    private String videoUrl;
    private String category;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getVideoUrl() { return videoUrl; }
    public void setVideoUrl(String videoUrl) { this.videoUrl = videoUrl; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}