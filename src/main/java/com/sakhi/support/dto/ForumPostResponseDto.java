package com.sakhi.support.dto;

import java.time.LocalDateTime;

public class ForumPostResponseDto {

    private Long id;
    private Long userId;
    private String userName;
    private String title;
    private String content;
    private String category;
    private LocalDateTime createdAt;

    public ForumPostResponseDto() {}

    public ForumPostResponseDto(Long id, Long userId, String userName, String title,
                                 String content, String category, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.category = category;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}