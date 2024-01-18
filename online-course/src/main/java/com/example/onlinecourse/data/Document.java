package com.example.onlinecourse.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "document_tlb")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentId;

    @Column(name = "document_title")
    private String documentTitle;

    @Column(name = "document_Path")
    private String documentPath;

    @ManyToOne
    @JoinColumn(name = "study_material_id_fk")
    @JsonBackReference
    private StudyMaterial studyMaterial;

    @JsonProperty("studyMaterialId")
    public int getStudyMaterialId() {
        return studyMaterial != null ? studyMaterial.getStudyMaterialId() : 0;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    public StudyMaterial getStudyMaterial() {
        return studyMaterial;
    }

    public void setStudyMaterial(StudyMaterial studyMaterial) {
        this.studyMaterial = studyMaterial;
    }

    public String getFileName() {
        if (documentPath != null) {
            String[] pathSegments = documentPath.split("/");
            return pathSegments[pathSegments.length - 1];
        }
        return null;
    }


}
