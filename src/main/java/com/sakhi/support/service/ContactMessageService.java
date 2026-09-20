package com.sakhi.support.service;

import com.sakhi.support.dto.ContactMessageRequestDto;
import com.sakhi.support.dto.ContactMessageResponseDto;
import com.sakhi.support.model.ContactMessage;
import com.sakhi.support.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    public ContactMessageResponseDto submitMessage(ContactMessageRequestDto dto) {
        ContactMessage message = new ContactMessage();
        message.setName(dto.getName());
        message.setEmail(dto.getEmail());
        message.setSubject(dto.getSubject());
        message.setMessage(dto.getMessage());

        ContactMessage saved = contactMessageRepository.save(message);
        return toDto(saved);
    }

    public List<ContactMessageResponseDto> getAllMessages() {
        return contactMessageRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private ContactMessageResponseDto toDto(ContactMessage message) {
        return new ContactMessageResponseDto(
                message.getId(),
                message.getName(),
                message.getEmail(),
                message.getSubject(),
                message.getMessage(),
                message.isResolved()
        );
    }
}