package com.sakhi.support.repository;

import com.sakhi.support.model.SuccessStory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuccessStoryRepository extends JpaRepository<SuccessStory, Long> {
}