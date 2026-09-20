package com.sakhi.support.controller;

import com.sakhi.support.dto.GovernmentSchemeRequestDto;
import com.sakhi.support.dto.GovernmentSchemeResponseDto;
import com.sakhi.support.service.GovernmentSchemeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schemes")
public class GovernmentSchemeController {

    @Autowired
    private GovernmentSchemeService governmentSchemeService;

    @PostMapping
    public GovernmentSchemeResponseDto createScheme(@Valid @RequestBody GovernmentSchemeRequestDto dto) {
        return governmentSchemeService.createScheme(dto);
    }

    @GetMapping
    public List<GovernmentSchemeResponseDto> getAllSchemes() {
        return governmentSchemeService.getAllSchemes();
    }

    @GetMapping("/category/{category}")
    public List<GovernmentSchemeResponseDto> getSchemesByCategory(@PathVariable String category) {
        return governmentSchemeService.getSchemesByCategory(category);
    }
}