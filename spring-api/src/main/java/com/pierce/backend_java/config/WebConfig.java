package com.pierce.backend_java.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggingInterceptor());
    }
    
    static class LoggingInterceptor implements HandlerInterceptor {
        private static final Logger log = LoggerFactory.getLogger(LoggingInterceptor.class);
        
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
            log.info(">>> {} {} from {}", 
                request.getMethod(), 
                request.getRequestURI(), 
                request.getRemoteAddr());
            return true;
        }
        
        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
            log.info("<<< {} {} -> {}", 
                request.getMethod(), 
                request.getRequestURI(), 
                response.getStatus());
        }
    }
}
