package com.example.onlinecourse.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "study_material_tlb")
public class StudyMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studyMaterialId;

    @Column(name = "study_material_title")
    private String studyMaterialTitle;

    @OneToMany(mappedBy = "studyMaterial", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Document> documents;

    @OneToMany(mappedBy = "studyMaterial",cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JsonManagedReference
    private List<Video> videos;

    @ManyToOne
    @JoinColumn(name = "lesson_id_fk")
    @JsonBackReference
    private Lesson lesson;

    @JsonProperty("lessonId")
    public int getLessonId() {
        return lesson != null ? lesson.getLessonId() : 0;
    }

    public int getStudyMaterialId() {
        return studyMaterialId;
    }

    public void setStudyMaterialId(int studyMaterialId) {
        this.studyMaterialId = studyMaterialId;
    }

    public String getStudyMaterialTitle() {
        return studyMaterialTitle;
    }

    public void setStudyMaterialTitle(String studyMaterialTitle) {
        this.studyMaterialTitle = studyMaterialTitle;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
