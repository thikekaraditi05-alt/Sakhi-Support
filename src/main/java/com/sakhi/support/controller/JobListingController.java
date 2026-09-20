package com.sakhi.support.controller;

import com.sakhi.support.dto.JobListingRequestDto;
import com.sakhi.support.dto.JobListingResponseDto;
import com.sakhi.support.service.JobListingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobListingController {

    @Autowired
    private JobListingService jobListingService;

    @PostMapping
    public JobListingResponseDto createJob(@Valid @RequestBody JobListingRequestDto dto) {
        return jobListingService.createJob(dto);
    }

    @GetMapping
    public List<JobListingResponseDto> getAllJobs() {
        return jobListingService.getAllJobs();
    }

    @GetMapping("/type/{type}")
    public List<JobListingResponseDto> getJobsByType(@PathVariable String type) {
        return jobListingService.getJobsByType(type);
    }
}