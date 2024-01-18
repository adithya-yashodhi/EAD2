package com.example.onlinecourse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CORSConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:3000");
        config.addAllowedHeader("Authorization, Content-Type, X-Requested-With"); // You can specify allowed headers
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE")); // Allow only GET requests

        // Specify the path where your documents and videos are hosted
        config.addExposedHeader("Content-Disposition"); // This header is important for file downloads

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/documents/local/**", config);
        source.registerCorsConfiguration("/api/videos/local/**", config);
        return new CorsFilter(source);
    }


}
