package com.sakhi.support.controller;

import com.sakhi.support.dto.ChatRequestDto;
import com.sakhi.support.dto.ChatResponseDto;
import com.sakhi.support.service.ChatService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    public ChatResponseDto chat(@Valid @RequestBody ChatRequestDto dto) {
        return chatService.getReply(dto);
    }
}