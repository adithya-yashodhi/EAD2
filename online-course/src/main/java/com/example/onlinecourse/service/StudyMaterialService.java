package com.example.onlinecourse.service;

import com.example.onlinecourse.data.Document;
import com.example.onlinecourse.data.StudyMaterial;
import com.example.onlinecourse.data.StudyMaterialRepository;
import com.example.onlinecourse.data.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class StudyMaterialService {

    @Autowired
    private StudyMaterialRepository studyMaterialRepository;

    public StudyMaterial createStudyMaterial(StudyMaterial studyMaterial){
        return studyMaterialRepository.save(studyMaterial);
    }

    public List<StudyMaterial> getAllStudyMaterials(){
        return studyMaterialRepository.findAll();
    }

    public StudyMaterial getStudyMaterialById(int studyMaterialId){
        Optional<StudyMaterial> studyMaterialObj = studyMaterialRepository.findById(studyMaterialId);
        if(studyMaterialObj.isPresent()){
            return studyMaterialObj.get();
        }
        else {
            return null;
        }
    }

    public StudyMaterial updateStudyMaterial(@RequestBody StudyMaterial studyMaterial){
        return studyMaterialRepository.save(studyMaterial);
    }

    public void deleteStudyMaterial(int studyMaterialId){
        studyMaterialRepository.deleteById(studyMaterialId);
    }

    public StudyMaterial addDocumentToStudyMaterial(StudyMaterial studyMaterial, String documentPath) {
        Document document = new Document();
        document.setDocumentPath(documentPath);

        document.setStudyMaterial(studyMaterial);
        studyMaterial.getDocuments().add(document);
        return studyMaterialRepository.save(studyMaterial);
    }

    public StudyMaterial addVideoToStudyMaterial(StudyMaterial studyMaterial, String videoPath) {
        Video video = new Video();
        video.setVideoPath(videoPath);

        video.setStudyMaterial(studyMaterial);
        studyMaterial.getVideos().add(video);
        return studyMaterialRepository.save(studyMaterial);
    }

}
