package com.example.onlinecourse.controller;

import com.example.onlinecourse.data.StudyMaterial;
import com.example.onlinecourse.service.StudyMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class StudyMaterialController {

    @Autowired
    private StudyMaterialService studyMaterialService;

    @PostMapping(path = "/studyMaterials")
    public StudyMaterial createStudyMaterial(@RequestBody StudyMaterial studyMaterial){
        return studyMaterialService.createStudyMaterial(studyMaterial);
    }

    @GetMapping(path = "/studyMaterials")
    public List<StudyMaterial> getAllStudyMaterials(){
        return studyMaterialService.getAllStudyMaterials();
    }

    @GetMapping(path = "/studyMaterials/{studyMaterialId}")
    public StudyMaterial getStudyMaterialById(@PathVariable int studyMaterialId){
        return studyMaterialService.getStudyMaterialById(studyMaterialId);
    }

    @PutMapping(path = "/studyMaterials")
    public StudyMaterial updateStudyMaterial(@RequestBody StudyMaterial studyMaterial){
        return studyMaterialService.updateStudyMaterial(studyMaterial);
    }

    @DeleteMapping(path = "/studyMaterials/{studyMaterialId}")
    public void deleteStudyMaterial(@PathVariable int studyMaterialId){
        studyMaterialService.deleteStudyMaterial(studyMaterialId);
    }

    @PostMapping("/{studyMaterialId}/add-document")
    public ResponseEntity<StudyMaterial> addDocumentToStudyMaterial(
            @PathVariable int studyMaterialId,
            @RequestParam String documentPath
    ) {
        StudyMaterial studyMaterial = studyMaterialService.getStudyMaterialById(studyMaterialId);
        if (studyMaterial != null) {
            StudyMaterial updatedStudyMaterial = studyMaterialService.addDocumentToStudyMaterial(studyMaterial, documentPath);
            return ResponseEntity.ok(updatedStudyMaterial);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{studyMaterialId}/add-video")
    public ResponseEntity<StudyMaterial> addVideoToStudyMaterial(
            @PathVariable int studyMaterialId,
            @RequestParam String videoPath
    ) {
        StudyMaterial studyMaterial = studyMaterialService.getStudyMaterialById(studyMaterialId);
        if (studyMaterial != null) {
            StudyMaterial updatedStudyMaterial = studyMaterialService.addVideoToStudyMaterial(studyMaterial, videoPath);
            return ResponseEntity.ok(updatedStudyMaterial);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
