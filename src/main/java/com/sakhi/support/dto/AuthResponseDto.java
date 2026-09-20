package com.sakhi.support.dto;

public class AuthResponseDto {

    private String message;
    private Long userId;
    private String fullName;
    private String email;
    private String token;

    public AuthResponseDto() {}

    public AuthResponseDto(String message, Long userId, String fullName, String email, String token) {
        this.message = message;
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}