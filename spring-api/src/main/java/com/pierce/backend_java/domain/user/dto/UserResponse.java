package com.pierce.backend_java.domain.user.dto;

import java.time.OffsetDateTime;

public record UserResponse(
        Long id,
        String email,
        String name,
        OffsetDateTime createdAt
) {}
