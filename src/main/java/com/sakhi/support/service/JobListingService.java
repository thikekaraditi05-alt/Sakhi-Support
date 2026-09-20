package com.sakhi.support.service;

import com.sakhi.support.dto.JobListingRequestDto;
import com.sakhi.support.dto.JobListingResponseDto;
import com.sakhi.support.model.JobListing;
import com.sakhi.support.repository.JobListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobListingService {

    @Autowired
    private JobListingRepository jobListingRepository;

    public JobListingResponseDto createJob(JobListingRequestDto dto) {
        JobListing job = new JobListing();
        job.setTitle(dto.getTitle());
        job.setCompanyName(dto.getCompanyName());
        job.setDescription(dto.getDescription());
        job.setLocation(dto.getLocation());
        job.setType(dto.getType());
        job.setApplyLink(dto.getApplyLink());
        job.setSalaryRange(dto.getSalaryRange());

        JobListing saved = jobListingRepository.save(job);
        return toDto(saved);
    }

    public List<JobListingResponseDto> getAllJobs() {
        return jobListingRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<JobListingResponseDto> getJobsByType(String type) {
        return jobListingRepository.findByType(type)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private JobListingResponseDto toDto(JobListing job) {
        return new JobListingResponseDto(
                job.getId(),
                job.getTitle(),
                job.getCompanyName(),
                job.getDescription(),
                job.getLocation(),
                job.getType(),
                job.getApplyLink(),
                job.getSalaryRange()
        );
    }
}