package com.sakhi.support.service;

import com.sakhi.support.dto.CareerResourceRequestDto;
import com.sakhi.support.dto.CareerResourceResponseDto;
import com.sakhi.support.model.CareerResource;
import com.sakhi.support.repository.CareerResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CareerResourceService {

    @Autowired
    private CareerResourceRepository careerResourceRepository;

    public CareerResourceResponseDto createResource(CareerResourceRequestDto dto) {
        CareerResource resource = new CareerResource();
        resource.setTitle(dto.getTitle());
        resource.setContent(dto.getContent());
        resource.setCategory(dto.getCategory());
        resource.setResourceLink(dto.getResourceLink());

        CareerResource saved = careerResourceRepository.save(resource);
        return toDto(saved);
    }

    public List<CareerResourceResponseDto> getAllResources() {
        return careerResourceRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<CareerResourceResponseDto> getResourcesByCategory(String category) {
        return careerResourceRepository.findByCategory(category)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private CareerResourceResponseDto toDto(CareerResource resource) {
        return new CareerResourceResponseDto(
                resource.getId(),
                resource.getTitle(),
                resource.getContent(),
                resource.getCategory(),
                resource.getResourceLink()
        );
    }
}