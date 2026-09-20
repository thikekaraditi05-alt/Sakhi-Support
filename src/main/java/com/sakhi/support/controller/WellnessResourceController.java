package com.sakhi.support.controller;

import com.sakhi.support.dto.WellnessResourceRequestDto;
import com.sakhi.support.dto.WellnessResourceResponseDto;
import com.sakhi.support.service.WellnessResourceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wellness")
public class WellnessResourceController {

    @Autowired
    private WellnessResourceService wellnessResourceService;

    @PostMapping
    public WellnessResourceResponseDto createResource(@Valid @RequestBody WellnessResourceRequestDto dto) {
        return wellnessResourceService.createResource(dto);
    }

    @GetMapping
    public List<WellnessResourceResponseDto> getAllResources() {
        return wellnessResourceService.getAllResources();
    }

    @GetMapping("/category/{category}")
    public List<WellnessResourceResponseDto> getResourcesByCategory(@PathVariable String category) {
        return wellnessResourceService.getResourcesByCategory(category);
    }
}