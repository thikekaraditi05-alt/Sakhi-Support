package com.sakhi.support.controller;

import com.sakhi.support.dto.SuccessStoryRequestDto;
import com.sakhi.support.dto.SuccessStoryResponseDto;
import com.sakhi.support.service.SuccessStoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/success-stories")
public class SuccessStoryController {

    @Autowired
    private SuccessStoryService successStoryService;

    @PostMapping
    public SuccessStoryResponseDto createStory(@Valid @RequestBody SuccessStoryRequestDto dto) {
        return successStoryService.createStory(dto);
    }

    @GetMapping
    public List<SuccessStoryResponseDto> getAllStories() {
        return successStoryService.getAllStories();
    }
}