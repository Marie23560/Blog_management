package com.example.blogmanagement.repository;

import com.example.blogmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {


    org.springframework.security.core.userdetails.User findByEmail(String email);


    boolean existsByEmail(String email);


    boolean existsByUsername(String username);
}