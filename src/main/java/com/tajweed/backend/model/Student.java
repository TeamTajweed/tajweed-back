package com.tajweed.backend.model;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "student_generator")
    @SequenceGenerator(name = "student_generator", allocationSize = 1)
    private Long id;

    private String name;
    private String surname;

    public Student() {

    }
    public Student(Long id, String name, String surname){
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
