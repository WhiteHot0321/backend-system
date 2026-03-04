package com.pierce.backend_java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {
    
    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "backend-java");
        response.put("timestamp", System.currentTimeMillis());
        return response;
    }
    
    @GetMapping("/health-ping")  // ← 改名字避免衝突
    public String ping() {
        return "pong";
    }
}
