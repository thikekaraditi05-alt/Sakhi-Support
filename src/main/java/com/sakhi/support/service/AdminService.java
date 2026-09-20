package com.sakhi.support.service;

import com.sakhi.support.dto.AuthResponseDto;
import com.sakhi.support.dto.DashboardStatsDto;
import com.sakhi.support.model.ContactMessage;
import com.sakhi.support.model.User;
import com.sakhi.support.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private JobListingRepository jobListingRepository;

    @Autowired
    private GovernmentSchemeRepository governmentSchemeRepository;

    @Autowired
    private ForumPostRepository forumPostRepository;

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    public DashboardStatsDto getStats() {
        long unresolvedCount = contactMessageRepository.findAll()
                .stream()
                .filter(m -> !m.isResolved())
                .count();

        return new DashboardStatsDto(
                userRepository.count(),
                courseRepository.count(),
                jobListingRepository.count(),
                governmentSchemeRepository.count(),
                forumPostRepository.count(),
                unresolvedCount
        );
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deactivateUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setIsActive(false);
        userRepository.save(user);
    }

    public void resolveContactMessage(Long messageId) {
        ContactMessage message = contactMessageRepository.findById(messageId)
                .orElseThrow(() -> new RuntimeException("Message not found"));
        message.setResolved(true);
        contactMessageRepository.save(message);
    }
}