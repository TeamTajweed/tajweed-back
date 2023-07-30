package com.tajweed.backend.model;

import org.springframework.data.annotation.Id;

public class Teacher {

    @Id
    private String id;

    private String entity;

    private String name;

    private String password;

    private String email;

    private String resume;

    public Teacher() {}

    public Teacher(String id, String entity, String name, String password, String email, String resume){
        this.id = id;
        this.entity = entity;
        this.name = name;
        this.password = password;
        this.email = email;
        this.resume = resume;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }
    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        assert name.isEmpty();
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getResume() {
        return resume;
    }
    public void setResume(String resume) {
        this.resume = resume;
    }
}
