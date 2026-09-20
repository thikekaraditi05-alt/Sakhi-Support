package com.sakhi.support.dto;

public class SuccessStoryResponseDto {

    private Long id;
    private String title;
    private String content;
    private String personName;
    private String imageUrl;

    public SuccessStoryResponseDto() {}

    public SuccessStoryResponseDto(Long id, String title, String content, String personName, String imageUrl) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.personName = personName;
        this.imageUrl = imageUrl;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getPersonName() { return personName; }
    public void setPersonName(String personName) { this.personName = personName; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}