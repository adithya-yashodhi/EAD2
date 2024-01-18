package com.example.onlinecourse.controller;

import com.example.onlinecourse.data.Document;
import com.example.onlinecourse.data.Video;
import com.example.onlinecourse.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/api/videos/{videoId}/content")
    public ResponseEntity<byte[]> getVideoContent(@PathVariable int videoId) {
        Video video = videoService.getVideoById(videoId);

        if (video != null) {
            String videoPath = video.getVideoPath();

            try {
                // Read the content of the document file
                byte[] videoContent = Files.readAllBytes(Paths.get(videoPath));

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); // Set the appropriate content type
                headers.setContentDispositionFormData("attachment", video.getFileName());

                return new ResponseEntity<>(videoContent, headers, HttpStatus.OK);
            } catch (IOException e) {
                // Handle any potential errors while loading the document
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/api/videos/local/{videoTitle:.+}")
    public ResponseEntity<byte[]> getLocalVideo(@PathVariable String videoTitle) {
        String localVideoDirectory = "C:/Users/User/Desktop/course/SE/";

        String absolutePath = localVideoDirectory + videoTitle;

        try {
            byte[] videoContent = Files.readAllBytes(Paths.get(absolutePath));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", videoTitle);

            return new ResponseEntity<>(videoContent, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
