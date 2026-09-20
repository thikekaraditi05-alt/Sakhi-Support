package com.sakhi.support.dto;

public class LessonResponseDto {

    private Long id;
    private String title;
    private String videoUrl;
    private String content;
    private Integer orderIndex;
    private Integer durationMinutes;

    public LessonResponseDto() {}

    public LessonResponseDto(Long id, String title, String videoUrl, String content,
                              Integer orderIndex, Integer durationMinutes) {
        this.id = id;
        this.title = title;
        this.videoUrl = videoUrl;
        this.content = content;
        this.orderIndex = orderIndex;
        this.durationMinutes = durationMinutes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
}