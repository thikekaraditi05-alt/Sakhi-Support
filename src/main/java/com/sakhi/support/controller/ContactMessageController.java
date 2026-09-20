package com.sakhi.support.controller;

import com.sakhi.support.dto.ContactMessageRequestDto;
import com.sakhi.support.dto.ContactMessageResponseDto;
import com.sakhi.support.service.ContactMessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactMessageController {

    @Autowired
    private ContactMessageService contactMessageService;

    @PostMapping
    public ContactMessageResponseDto submitMessage(@Valid @RequestBody ContactMessageRequestDto dto) {
        return contactMessageService.submitMessage(dto);
    }

    @GetMapping
    public List<ContactMessageResponseDto> getAllMessages() {
        return contactMessageService.getAllMessages();
    }
}