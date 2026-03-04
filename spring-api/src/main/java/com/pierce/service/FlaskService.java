package com.pierce.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlaskService {
    private final RestTemplate restTemplate;

    public FlaskService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String callFlask() {
        return restTemplate.getForObject(
            "http://localhost:5000/api/ollama",
            String.class
        );
    }
}
