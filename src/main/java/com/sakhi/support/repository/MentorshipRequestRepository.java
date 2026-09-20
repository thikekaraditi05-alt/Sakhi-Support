package com.sakhi.support.repository;

import com.sakhi.support.model.MentorshipRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentorshipRequestRepository extends JpaRepository<MentorshipRequest, Long> {
    List<MentorshipRequest> findByMenteeId(Long menteeId);
    List<MentorshipRequest> findByMentorId(Long mentorId);
}