package com.sakhi.support.repository;

import com.sakhi.support.model.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobListingRepository extends JpaRepository<JobListing, Long> {
    List<JobListing> findByType(String type);
}