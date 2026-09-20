package com.sakhi.support.dto;

public class CareerResourceResponseDto {

    private Long id;
    private String title;
    private String content;
    private String category;
    private String resourceLink;

    public CareerResourceResponseDto() {}

    public CareerResourceResponseDto(Long id, String title, String content, String category, String resourceLink) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.resourceLink = resourceLink;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getResourceLink() { return resourceLink; }
    public void setResourceLink(String resourceLink) { this.resourceLink = resourceLink; }
}