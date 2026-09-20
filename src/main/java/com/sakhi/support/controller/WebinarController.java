package com.sakhi.support.controller;

import com.sakhi.support.dto.WebinarRequestDto;
import com.sakhi.support.dto.WebinarResponseDto;
import com.sakhi.support.service.WebinarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/webinars")
public class WebinarController {

    @Autowired
    private WebinarService webinarService;

    @PostMapping
    public WebinarResponseDto createWebinar(@Valid @RequestBody WebinarRequestDto dto) {
        return webinarService.createWebinar(dto);
    }

    @GetMapping
    public List<WebinarResponseDto> getAllWebinars() {
        return webinarService.getAllWebinars();
    }
}