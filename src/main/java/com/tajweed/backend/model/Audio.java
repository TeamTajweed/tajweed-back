package com.tajweed.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Audio {

    @Id
    private String id;

    @DBRef
    private Student Student;

    private String idEntity;

    private String chapter;

    private String verse;

    public Audio() {

    }

    public Audio(String id, Student student, String idEntity, String chapter, String verse) {
        this.id = id;
        this.idEntity = idEntity;
        this.chapter = chapter;
        this.verse = verse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getVerse() {
        return verse;
    }

    public void setVerse(String verse) {
        this.verse = verse;
    }

    public Student getStudent() {
        return Student;
    }

    public void setStudent(Student student) {
        Student = student;
    }

    public String getIdEntity() {
        return idEntity;
    }

    public void setIdEntity(String idEntity) {
        this.idEntity = idEntity;
    }
}
