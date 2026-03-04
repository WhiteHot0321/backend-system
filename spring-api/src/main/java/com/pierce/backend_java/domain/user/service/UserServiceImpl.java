package com.pierce.backend_java.domain.user.service;

import com.pierce.backend_java.domain.user.dto.UserCreateRequest;
import com.pierce.backend_java.domain.user.dto.UserResponse;
import com.pierce.backend_java.domain.user.entity.UserEntity;
import com.pierce.backend_java.domain.user.repo.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public UserResponse create(UserCreateRequest req) {
        repo.findByEmail(req.email()).ifPresent(u -> {
            throw new IllegalArgumentException("email already exists");
        });

        UserEntity e = new UserEntity();
        e.setEmail(req.email());
        e.setName(req.name());

        UserEntity saved = repo.save(e);
        return new UserResponse(saved.getId(), saved.getEmail(), saved.getName(), saved.getCreatedAt());
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getById(Long id) {
        UserEntity e = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("user not found"));
        return new UserResponse(e.getId(), e.getEmail(), e.getName(), e.getCreatedAt());
    }
}
