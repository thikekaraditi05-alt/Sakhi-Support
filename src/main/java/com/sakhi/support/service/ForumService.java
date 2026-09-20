package com.sakhi.support.service;

import com.sakhi.support.dto.*;
import com.sakhi.support.model.ForumComment;
import com.sakhi.support.model.ForumPost;
import com.sakhi.support.model.User;
import com.sakhi.support.repository.ForumCommentRepository;
import com.sakhi.support.repository.ForumPostRepository;
import com.sakhi.support.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForumService {

    @Autowired
    private ForumPostRepository forumPostRepository;

    @Autowired
    private ForumCommentRepository forumCommentRepository;

    @Autowired
    private UserRepository userRepository;

    public ForumPostResponseDto createPost(ForumPostRequestDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        ForumPost post = new ForumPost();
        post.setUser(user);
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setCategory(dto.getCategory());

        ForumPost saved = forumPostRepository.save(post);
        return toPostDto(saved);
    }

    public List<ForumPostResponseDto> getAllPosts() {
        return forumPostRepository.findAll()
                .stream()
                .map(this::toPostDto)
                .collect(Collectors.toList());
    }

    public ForumCommentResponseDto addComment(ForumCommentRequestDto dto) {
        ForumPost post = forumPostRepository.findById(dto.getPostId())
                .orElseThrow(() -> new RuntimeException("Post not found"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        ForumComment comment = new ForumComment();
        comment.setPost(post);
        comment.setUser(user);
        comment.setContent(dto.getContent());

        ForumComment saved = forumCommentRepository.save(comment);
        return toCommentDto(saved);
    }

    public List<ForumCommentResponseDto> getCommentsForPost(Long postId) {
        return forumCommentRepository.findByPostIdOrderByCreatedAtAsc(postId)
                .stream()
                .map(this::toCommentDto)
                .collect(Collectors.toList());
    }

    private ForumPostResponseDto toPostDto(ForumPost post) {
        return new ForumPostResponseDto(
                post.getId(),
                post.getUser().getId(),
                post.getUser().getFullName(),
                post.getTitle(),
                post.getContent(),
                post.getCategory(),
                post.getCreatedAt()
        );
    }

    private ForumCommentResponseDto toCommentDto(ForumComment comment) {
        return new ForumCommentResponseDto(
                comment.getId(),
                comment.getUser().getId(),
                comment.getUser().getFullName(),
                comment.getContent(),
                comment.getCreatedAt()
        );
    }
}