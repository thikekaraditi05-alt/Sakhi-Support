package com.sakhi.support.repository;

import com.sakhi.support.model.CareerResource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CareerResourceRepository extends JpaRepository<CareerResource, Long> {
    List<CareerResource> findByCategory(String category);
}