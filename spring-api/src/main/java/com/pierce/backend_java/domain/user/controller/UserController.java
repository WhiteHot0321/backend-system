package com.pierce.backend_java.domain.user.controller;

import com.pierce.backend_java.common.ApiResponse;
import com.pierce.backend_java.domain.user.dto.UserCreateRequest;
import com.pierce.backend_java.domain.user.dto.UserResponse;
import com.pierce.backend_java.domain.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private final UserService svc;
    
    public UserController(UserService svc) {
        this.svc = svc;
    }
    
    @PostMapping
    public ApiResponse<UserResponse> create(@Valid @RequestBody UserCreateRequest req) {
        return ApiResponse.success(svc.create(req));
    }
    
    @GetMapping("/{id}")
    public ApiResponse<UserResponse> get(@PathVariable Long id) {
        return ApiResponse.success(svc.getById(id));
    }
}
