package com.sakhi.support.controller;

import com.sakhi.support.dto.VideoTutorialRequestDto;
import com.sakhi.support.dto.VideoTutorialResponseDto;
import com.sakhi.support.service.VideoTutorialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
public class VideoTutorialController {

    @Autowired
    private VideoTutorialService videoTutorialService;

    @PostMapping
    public VideoTutorialResponseDto createVideo(@Valid @RequestBody VideoTutorialRequestDto dto) {
        return videoTutorialService.createVideo(dto);
    }

    @GetMapping
    public List<VideoTutorialResponseDto> getAllVideos() {
        return videoTutorialService.getAllVideos();
    }
}