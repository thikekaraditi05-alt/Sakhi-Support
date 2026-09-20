package com.sakhi.support.dto;

import jakarta.validation.constraints.NotBlank;

public class ChatRequestDto {

    private Long userId;

    @NotBlank(message = "Message is required")
    private String message;

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}