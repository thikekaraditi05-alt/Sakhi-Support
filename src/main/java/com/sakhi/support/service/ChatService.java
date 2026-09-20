package com.sakhi.support.service;

import com.sakhi.support.dto.ChatRequestDto;
import com.sakhi.support.dto.ChatResponseDto;
import com.sakhi.support.model.ChatLog;
import com.sakhi.support.repository.ChatLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private ChatLogRepository chatLogRepository;

    public ChatResponseDto getReply(ChatRequestDto dto) {

        String msg = dto.getMessage().toLowerCase();
        String reply;
        String module;

        if (msg.contains("course") || msg.contains("learn") || msg.contains("tutorial") || msg.contains("webinar")) {
            reply = "You can explore courses, video tutorials, and webinars in our Learning Hub section!";
            module = "Learning Hub";

        } else if (msg.contains("job") || msg.contains("internship") || msg.contains("career") || msg.contains("interview")) {
            reply = "Check out our Jobs & Career section for listings, internships, and interview prep resources!";
            module = "Jobs & Career";

        } else if (msg.contains("health") || msg.contains("wellness") || msg.contains("mental") || msg.contains("nutrition") || msg.contains("fitness")) {
            reply = "Our Women's Health & Wellness section has resources on health awareness, mental health, and nutrition.";
            module = "Wellness";

        } else if (msg.contains("scheme") || msg.contains("government") || msg.contains("benefit")) {
            reply = "You'll find government schemes for women in our Government Schemes section, including eligibility and how to apply.";
            module = "Government Schemes";

        } else if (msg.contains("mentor") || msg.contains("guidance")) {
            reply = "You can connect with a mentor through our Mentorship section!";
            module = "Mentorship";

        } else if (msg.contains("forum") || msg.contains("community") || msg.contains("discuss")) {
            reply = "Join discussions and connect with others in our Community Forum!";
            module = "Community Forum";

        } else if (msg.contains("contact") || msg.contains("support") || msg.contains("help") || msg.contains("problem")) {
            reply = "You can reach out to us anytime through the Contact/Support section, and our team will assist you.";
            module = "Contact/Support";

        } else if (msg.contains("hi") || msg.contains("hello") || msg.contains("hey")) {
            reply = "Hi there! I'm Sakhi's assistant. Ask me about courses, jobs, wellness, government schemes, mentorship, or the community forum!";
            module = "General";

        } else {
            reply = "I'm not sure about that yet, but you can explore Learning Hub, Jobs & Career, Wellness, Government Schemes, Mentorship, or the Community Forum from the menu!";
            module = "General";
        }

        ChatLog log = new ChatLog();
        log.setUserId(dto.getUserId());
        log.setUserMessage(dto.getMessage());
        log.setBotResponse(reply);
        chatLogRepository.save(log);

        return new ChatResponseDto(reply, module);
    }
}