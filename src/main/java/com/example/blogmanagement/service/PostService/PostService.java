package com.example.blogmanagement.service.PostService;

import com.example.blogmanagement.dto.PostDto.PagedResponse;
import com.example.blogmanagement.dto.PostDto.PostRequestDto;
import com.example.blogmanagement.dto.PostDto.PostResponseDto;


public interface PostService {


    PostResponseDto createPost(PostRequestDto request);


    PostResponseDto getPost(String postId);


    PostResponseDto updatePost(String postId, PostRequestDto request);


    void deletePost(String postId);


    PagedResponse<PostResponseDto> listPosts(int page, int size, String search);
}