package com.tajweed.backend.model;

import org.springframework.data.annotation.Id;

public class Audio {

    @Id
    private String id;

    private String idStudent;

    private String idEntity;

    private String chapter;

    private String verse;

    public Audio() {

    }
    public Audio(String id, String idStudent, String idEntity, String chapter, String verse){
        this.id = id;
        this.idStudent = idStudent;
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

    public String getIdStudent() {
        return idStudent;
    }
    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdEntity() {
        return idEntity;
    }
    public void setIdEntity(String idEntity) {
        this.idEntity = idEntity;
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
}
