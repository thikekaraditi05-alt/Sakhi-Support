package com.sakhi.support.service;

import com.sakhi.support.dto.MentorshipRequestDto;
import com.sakhi.support.dto.MentorshipResponseDto;
import com.sakhi.support.model.MentorshipRequest;
import com.sakhi.support.model.User;
import com.sakhi.support.repository.MentorshipRequestRepository;
import com.sakhi.support.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MentorshipService {

    @Autowired
    private MentorshipRequestRepository mentorshipRequestRepository;

    @Autowired
    private UserRepository userRepository;

    public MentorshipResponseDto sendRequest(MentorshipRequestDto dto) {
        User mentee = userRepository.findById(dto.getMenteeId())
                .orElseThrow(() -> new RuntimeException("Mentee not found"));

        User mentor = userRepository.findById(dto.getMentorId())
                .orElseThrow(() -> new RuntimeException("Mentor not found"));

        MentorshipRequest request = new MentorshipRequest();
        request.setMentee(mentee);
        request.setMentor(mentor);
        request.setMessage(dto.getMessage());

        MentorshipRequest saved = mentorshipRequestRepository.save(request);
        return toDto(saved);
    }

    public List<MentorshipResponseDto> getRequestsSentByMentee(Long menteeId) {
        return mentorshipRequestRepository.findByMenteeId(menteeId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<MentorshipResponseDto> getRequestsForMentor(Long mentorId) {
        return mentorshipRequestRepository.findByMentorId(mentorId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public MentorshipResponseDto updateStatus(Long requestId, String status) {
        MentorshipRequest request = mentorshipRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        request.setStatus(status);
        MentorshipRequest saved = mentorshipRequestRepository.save(request);
        return toDto(saved);
    }

    private MentorshipResponseDto toDto(MentorshipRequest request) {
        return new MentorshipResponseDto(
                request.getId(),
                request.getMentee().getId(),
                request.getMentee().getFullName(),
                request.getMentor().getId(),
                request.getMentor().getFullName(),
                request.getMessage(),
                request.getStatus(),
                request.getCreatedAt()
        );
    }
}