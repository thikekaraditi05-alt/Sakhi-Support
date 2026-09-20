package com.sakhi.support.controller;

import com.sakhi.support.dto.*;
import com.sakhi.support.service.ForumService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/forum")
public class ForumController {

    @Autowired
    private ForumService forumService;

    @PostMapping("/posts")
    public ForumPostResponseDto createPost(@Valid @RequestBody ForumPostRequestDto dto) {
        return forumService.createPost(dto);
    }

    @GetMapping("/posts")
    public List<ForumPostResponseDto> getAllPosts() {
        return forumService.getAllPosts();
    }

    @PostMapping("/comments")
    public ForumCommentResponseDto addComment(@Valid @RequestBody ForumCommentRequestDto dto) {
        return forumService.addComment(dto);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<ForumCommentResponseDto> getComments(@PathVariable Long postId) {
        return forumService.getCommentsForPost(postId);
    }
}