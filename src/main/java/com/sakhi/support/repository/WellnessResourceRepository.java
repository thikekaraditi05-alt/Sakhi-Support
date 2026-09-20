package com.sakhi.support.repository;

import com.sakhi.support.model.WellnessResource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WellnessResourceRepository extends JpaRepository<WellnessResource, Long> {
    List<WellnessResource> findByCategory(String category);
}