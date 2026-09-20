package com.sakhi.support.service;

import com.sakhi.support.dto.WebinarRequestDto;
import com.sakhi.support.dto.WebinarResponseDto;
import com.sakhi.support.model.Webinar;
import com.sakhi.support.repository.WebinarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WebinarService {

    @Autowired
    private WebinarRepository webinarRepository;

    public WebinarResponseDto createWebinar(WebinarRequestDto dto) {
        Webinar webinar = new Webinar();
        webinar.setTitle(dto.getTitle());
        webinar.setDescription(dto.getDescription());
        webinar.setSpeakerName(dto.getSpeakerName());
        webinar.setScheduledDate(dto.getScheduledDate());
        webinar.setLink(dto.getLink());
        webinar.setCategory(dto.getCategory());

        Webinar saved = webinarRepository.save(webinar);
        return toDto(saved);
    }

    public List<WebinarResponseDto> getAllWebinars() {
        return webinarRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private WebinarResponseDto toDto(Webinar webinar) {
        return new WebinarResponseDto(
                webinar.getId(),
                webinar.getTitle(),
                webinar.getDescription(),
                webinar.getSpeakerName(),
                webinar.getScheduledDate(),
                webinar.getLink(),
                webinar.getCategory()
        );
    }
}