package com.example.onlinecourse.controller;

import com.example.onlinecourse.data.Document;
import com.example.onlinecourse.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;
    @GetMapping("/api/documents/{documentId}/content")
    public ResponseEntity<byte[]> getDocumentContent(@PathVariable int documentId) {
        Document document = documentService.getDocumentById(documentId);

        if (document != null) {
            String documentPath = document.getDocumentPath();

            try {
                byte[] documentContent = Files.readAllBytes(Paths.get(documentPath));

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_PDF); // Set the appropriate content type
                headers.setContentDispositionFormData("attachment", document.getFileName());
                return new ResponseEntity<>(documentContent, headers, HttpStatus.OK);
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        return ResponseEntity.notFound().build();
    }
    @GetMapping("/api/documents/local/{documentTitle:.+}")
    public ResponseEntity<byte[]> getLocalDocument(@PathVariable String documentTitle) {
        String localDocumentDirectory = "C:/Users/User/Desktop/course/SE/";

        String absolutePath = localDocumentDirectory + documentTitle;

        try {
            byte[] documentContent = Files.readAllBytes(Paths.get(absolutePath));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", documentTitle);

            return new ResponseEntity<>(documentContent, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

