package com.example.blogmanagement.service.userService;

import com.example.blogmanagement.dto.PostDto.PagedResponse;
import com.example.blogmanagement.dto.PostDto.PostResponseDto;
import com.example.blogmanagement.dto.UserDto.UserRegistrationRequest;
import com.example.blogmanagement.dto.UserDto.UserResponseDto;


public interface UserService {


    static PagedResponse<UserResponseDto> listUser(int page, int size, String search) {
        return null;
    }


    UserResponseDto registerUser(UserRegistrationRequest request);


    UserResponseDto getUserById(Long userId);
}