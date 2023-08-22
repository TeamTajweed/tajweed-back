package com.tajweed.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teachers")
public class Teacher {

    @Id
    private String id;

    private String resume;

    @DBRef
    private User user;

    public Teacher() {

    }

    public Teacher(String id, String resume, User user) {
        this.id = id;
        this.resume = resume;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
