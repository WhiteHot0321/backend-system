package com.pierce.backend_java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {
    
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        
        // 允許的來源（Flask 的位址）
        config.setAllowedOrigins(Arrays.asList(
            "http://localhost:5000",  // Flask 開發環境
            "http://localhost:8000"   // 如果 Flask 用其他 port
        ));
        
        // 允許的 HTTP 方法
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        
        // 允許的 headers
        config.setAllowedHeaders(Arrays.asList("*"));
        
        // 允許帶 credentials（cookies, authorization headers）
        config.setAllowCredentials(true);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        
        return new CorsFilter(source);
    }
}
