package com.tajweed.backend.model;


import org.springframework.data.annotation.Id;

public class Student {

    @Id
    private String id;

    private String name;
    private String surname;

    public Student() {

    }
    public Student(String id, String name, String surname){
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        assert name.isEmpty();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
