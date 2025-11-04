package com.example.blogmanagement.service.CommentService;

import com.example.blogmanagement.dto.CommentDto.CommentRequestDto;
import com.example.blogmanagement.dto.CommentDto.CommentResponseDto;
import com.example.blogmanagement.dto.PostDto.PagedResponse;


public interface CommentService {


    CommentResponseDto createComment(CommentRequestDto request);


    CommentResponseDto getComment(String commentId);


    CommentResponseDto updateComment(String commentId, CommentRequestDto request);


    void deleteComment(String commentId);


    PagedResponse<CommentResponseDto> listCommentsByPostId(String postId, int page, int size);
}