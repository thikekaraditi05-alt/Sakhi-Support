package com.sakhi.support.repository;

import com.sakhi.support.model.Webinar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WebinarRepository extends JpaRepository<Webinar, Long> {
    List<Webinar> findByCategory(String category);
}