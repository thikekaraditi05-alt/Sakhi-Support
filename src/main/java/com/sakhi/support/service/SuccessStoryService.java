package com.sakhi.support.service;

import com.sakhi.support.dto.SuccessStoryRequestDto;
import com.sakhi.support.dto.SuccessStoryResponseDto;
import com.sakhi.support.model.SuccessStory;
import com.sakhi.support.repository.SuccessStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuccessStoryService {

    @Autowired
    private SuccessStoryRepository successStoryRepository;

    public SuccessStoryResponseDto createStory(SuccessStoryRequestDto dto) {
        SuccessStory story = new SuccessStory();
        story.setTitle(dto.getTitle());
        story.setContent(dto.getContent());
        story.setPersonName(dto.getPersonName());
        story.setImageUrl(dto.getImageUrl());

        SuccessStory saved = successStoryRepository.save(story);
        return toDto(saved);
    }

    public List<SuccessStoryResponseDto> getAllStories() {
        return successStoryRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private SuccessStoryResponseDto toDto(SuccessStory story) {
        return new SuccessStoryResponseDto(
                story.getId(),
                story.getTitle(),
                story.getContent(),
                story.getPersonName(),
                story.getImageUrl()
        );
    }
}