package com.example.onlinecourse.service;

import com.example.onlinecourse.data.Document;
import com.example.onlinecourse.data.Video;
import com.example.onlinecourse.data.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Value("${document.storage.path}")
    private String documentStoragePath;

    public String getDocumentPath(String documentTitle) {
        return documentStoragePath + "/" + documentTitle;
    }

    public Video getVideoById(int videoId){
        Optional<Video> videoObj = videoRepository.findById(videoId);
        if (videoObj.isPresent()){
            return videoObj.get();
        }
        else {
            return null;
        }
    }

}
