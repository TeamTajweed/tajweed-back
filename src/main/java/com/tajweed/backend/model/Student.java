package com.tajweed.backend.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Student {

    @Id
    private String id;

    private String name;

    private String progress;

    private String password;

    private String email;

    public Student() {}

    public Student(String id, String progress, String name, String password,String email){

        this.id = id;
        this.progress = progress;
        this.name = name;
        this.password = password;
        this.email = email;

    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getProgress() {
        return progress;
    }
    public void setProgress(String progress) {
        this.progress = progress;
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

}
