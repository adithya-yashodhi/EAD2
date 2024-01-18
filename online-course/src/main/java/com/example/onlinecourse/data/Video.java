package com.example.onlinecourse.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "video_tlb")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int videoId;

    @Column(name = "video_title")
    private String videoTitle;

    @Column(name = "video_path")
    private String videoPath;

    @ManyToOne
    @JoinColumn(name = "study_material_id_fk")
    @JsonBackReference
    private StudyMaterial studyMaterial;

    @JsonProperty("studyMaterialId")
    public int getStudyMaterialId() {
        return studyMaterial != null ? studyMaterial.getStudyMaterialId() : 0;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoUrl) {
        this.videoPath = videoUrl;
    }

    public StudyMaterial getStudyMaterial() {
        return studyMaterial;
    }

    public void setStudyMaterial(StudyMaterial studyMaterial) {
        this.studyMaterial = studyMaterial;
    }

    public String getFileName() {
        if (videoPath != null) {
            String[] pathSegments = videoPath.split("/");
            return pathSegments[pathSegments.length - 1];
        }
        return null;
    }
}
