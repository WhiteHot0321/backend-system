package com.pierce.backend_java.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserCreateRequest(
        @NotBlank @Email String email,
        @NotBlank @Size(max = 100) String name
) {}
