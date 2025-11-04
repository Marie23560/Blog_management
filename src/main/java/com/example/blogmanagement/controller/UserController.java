package com.example.blogmanagement.controller;

import com.example.blogmanagement.dto.PostDto.PagedResponse;
import com.example.blogmanagement.dto.PostDto.PostResponseDto;
import com.example.blogmanagement.dto.UserDto.UserRegistrationRequest;
import com.example.blogmanagement.dto.UserDto.UserResponseDto;
import com.example.blogmanagement.service.userService.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
@Tag(name = "Users", description = "Operations on user accounts")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @Operation(summary = "Register a new user")
    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@Valid @RequestBody UserRegistrationRequest request) {
        UserResponseDto response = userService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @Operation(summary = "Get user by ID")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Operation(summary = "List User with optional search and pagination")
    @GetMapping
    public ResponseEntity<PagedResponse<UserResponseDto>> listPosts(
            @Parameter(description = "Zero-based page index", in = ParameterIn.QUERY, schema = @Schema(defaultValue = "0"))
            @RequestParam(value = "page", defaultValue = "0") int page,
            @Parameter(description = "Number of records per page", in = ParameterIn.QUERY, schema = @Schema(defaultValue = "10"))
            @RequestParam(value = "size", defaultValue = "10") int size,
            @Parameter(description = "Search term to filter posts by title or content", in = ParameterIn.QUERY)
            @RequestParam(value = "search", required = false) String search) {
        PagedResponse<UserResponseDto> response = UserService.listUser(page, size, search);
        return ResponseEntity.ok(response);
    }
}
