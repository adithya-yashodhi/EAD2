package com.example.onlinecourse.service;

import com.example.onlinecourse.data.Document;
import com.example.onlinecourse.data.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Value("${document.storage.path}")
    private String documentStoragePath;

    public String getDocumentPath(String documentTitle) {
        return documentStoragePath + "/" + documentTitle;
    }
    public Document getDocumentById(int documentId){
        Optional<Document> documentObj = documentRepository.findById(documentId);
        if (documentObj.isPresent()){
            return documentObj.get();
        }
        else {
            return null;
        }
    }
}
