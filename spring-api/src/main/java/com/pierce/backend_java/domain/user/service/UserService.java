package com.pierce.backend_java.domain.user.service;

import com.pierce.backend_java.domain.user.dto.UserCreateRequest;
import com.pierce.backend_java.domain.user.dto.UserResponse;

public interface UserService {
    UserResponse create(UserCreateRequest req);
    UserResponse getById(Long id);
}
