package com.sakhi.support.repository;

import com.sakhi.support.model.GovernmentScheme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GovernmentSchemeRepository extends JpaRepository<GovernmentScheme, Long> {
    List<GovernmentScheme> findByCategory(String category);
}