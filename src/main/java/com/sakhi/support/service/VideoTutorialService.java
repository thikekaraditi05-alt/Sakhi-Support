package com.sakhi.support.service;

import com.sakhi.support.dto.VideoTutorialRequestDto;
import com.sakhi.support.dto.VideoTutorialResponseDto;
import com.sakhi.support.model.VideoTutorial;
import com.sakhi.support.repository.VideoTutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoTutorialService {

    @Autowired
    private VideoTutorialRepository videoTutorialRepository;

    public VideoTutorialResponseDto createVideo(VideoTutorialRequestDto dto) {
        VideoTutorial video = new VideoTutorial();
        video.setTitle(dto.getTitle());
        video.setDescription(dto.getDescription());
        video.setVideoUrl(dto.getVideoUrl());
        video.setCategory(dto.getCategory());

        VideoTutorial saved = videoTutorialRepository.save(video);
        return toDto(saved);
    }

    public List<VideoTutorialResponseDto> getAllVideos() {
        return videoTutorialRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private VideoTutorialResponseDto toDto(VideoTutorial video) {
        return new VideoTutorialResponseDto(
                video.getId(),
                video.getTitle(),
                video.getDescription(),
                video.getVideoUrl(),
                video.getCategory()
        );
    }
}