package com.sakhi.support.service;

import com.sakhi.support.dto.GovernmentSchemeRequestDto;
import com.sakhi.support.dto.GovernmentSchemeResponseDto;
import com.sakhi.support.model.GovernmentScheme;
import com.sakhi.support.repository.GovernmentSchemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GovernmentSchemeService {

    @Autowired
    private GovernmentSchemeRepository governmentSchemeRepository;

    public GovernmentSchemeResponseDto createScheme(GovernmentSchemeRequestDto dto) {
        GovernmentScheme scheme = new GovernmentScheme();
        scheme.setTitle(dto.getTitle());
        scheme.setDescription(dto.getDescription());
        scheme.setEligibility(dto.getEligibility());
        scheme.setBenefits(dto.getBenefits());
        scheme.setApplyLink(dto.getApplyLink());
        scheme.setCategory(dto.getCategory());

        GovernmentScheme saved = governmentSchemeRepository.save(scheme);
        return toDto(saved);
    }

    public List<GovernmentSchemeResponseDto> getAllSchemes() {
        return governmentSchemeRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<GovernmentSchemeResponseDto> getSchemesByCategory(String category) {
        return governmentSchemeRepository.findByCategory(category)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private GovernmentSchemeResponseDto toDto(GovernmentScheme scheme) {
        return new GovernmentSchemeResponseDto(
                scheme.getId(),
                scheme.getTitle(),
                scheme.getDescription(),
                scheme.getEligibility(),
                scheme.getBenefits(),
                scheme.getApplyLink(),
                scheme.getCategory()
        );
    }
}