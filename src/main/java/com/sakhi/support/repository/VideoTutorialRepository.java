package com.sakhi.support.repository;

import com.sakhi.support.model.VideoTutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoTutorialRepository extends JpaRepository<VideoTutorial, Long> {
    List<VideoTutorial> findByCategory(String category);
}