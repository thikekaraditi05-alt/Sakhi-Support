package com.sakhi.support.dto;

import jakarta.validation.constraints.NotBlank;

public class CareerResourceRequestDto {

    @NotBlank(message = "Title is required")
    private String title;

    private String content;
    private String category;
    private String resourceLink;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getResourceLink() { return resourceLink; }
    public void setResourceLink(String resourceLink) { this.resourceLink = resourceLink; }
}