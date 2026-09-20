package com.sakhi.support.service;

import com.sakhi.support.dto.WellnessResourceRequestDto;
import com.sakhi.support.dto.WellnessResourceResponseDto;
import com.sakhi.support.model.WellnessResource;
import com.sakhi.support.repository.WellnessResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WellnessResourceService {

    @Autowired
    private WellnessResourceRepository wellnessResourceRepository;

    public WellnessResourceResponseDto createResource(WellnessResourceRequestDto dto) {
        WellnessResource resource = new WellnessResource();
        resource.setTitle(dto.getTitle());
        resource.setContent(dto.getContent());
        resource.setCategory(dto.getCategory());
        resource.setImageUrl(dto.getImageUrl());
        resource.setResourceLink(dto.getResourceLink());

        WellnessResource saved = wellnessResourceRepository.save(resource);
        return toDto(saved);
    }

    public List<WellnessResourceResponseDto> getAllResources() {
        return wellnessResourceRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<WellnessResourceResponseDto> getResourcesByCategory(String category) {
        return wellnessResourceRepository.findByCategory(category)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private WellnessResourceResponseDto toDto(WellnessResource resource) {
        return new WellnessResourceResponseDto(
                resource.getId(),
                resource.getTitle(),
                resource.getContent(),
                resource.getCategory(),
                resource.getImageUrl(),
                resource.getResourceLink()
        );
    }
}