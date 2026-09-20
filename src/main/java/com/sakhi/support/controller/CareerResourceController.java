package com.sakhi.support.controller;

import com.sakhi.support.dto.CareerResourceRequestDto;
import com.sakhi.support.dto.CareerResourceResponseDto;
import com.sakhi.support.service.CareerResourceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/career-resources")
public class CareerResourceController {

    @Autowired
    private CareerResourceService careerResourceService;

    @PostMapping
    public CareerResourceResponseDto createResource(@Valid @RequestBody CareerResourceRequestDto dto) {
        return careerResourceService.createResource(dto);
    }

    @GetMapping
    public List<CareerResourceResponseDto> getAllResources() {
        return careerResourceService.getAllResources();
    }

    @GetMapping("/category/{category}")
    public List<CareerResourceResponseDto> getResourcesByCategory(@PathVariable String category) {
        return careerResourceService.getResourcesByCategory(category);
    }
}