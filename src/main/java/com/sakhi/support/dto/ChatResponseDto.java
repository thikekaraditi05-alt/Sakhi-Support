package com.sakhi.support.dto;

public class ChatResponseDto {

    private String reply;
    private String suggestedModule;

    public ChatResponseDto() {}

    public ChatResponseDto(String reply, String suggestedModule) {
        this.reply = reply;
        this.suggestedModule = suggestedModule;
    }

    public String getReply() { return reply; }
    public void setReply(String reply) { this.reply = reply; }

    public String getSuggestedModule() { return suggestedModule; }
    public void setSuggestedModule(String suggestedModule) { this.suggestedModule = suggestedModule; }
}