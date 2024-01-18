package com.example.onlinecourse.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Value("${document.storage.path}")
    private String documentStoragePath;

    public String getDocumentStoragePath() {
        return documentStoragePath;
    }
}
