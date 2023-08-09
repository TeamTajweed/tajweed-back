package com.tajweed.backend.model;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestData {

    private final MongoTemplate mongoTemplate;

    public TestData(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostConstruct
    public void seedData() {

        //  Student data
        for (int i = 0; i < 50; i++) {
            Student student = new Student();
            student.setName("Student " + i);
            student.setProgress("Progress " + i);
            student.setPassword("password" + i);
            student.setEmail("student" + i + "@example.com");
            mongoTemplate.save(student);
        }

        //  Teacher data
        for (int i = 0; i < 50; i++) {
            Teacher teacher = new Teacher();
            teacher.setEntity("Entity " + i);
            teacher.setName("Teacher " + i);
            teacher.setPassword("password" + i);
            teacher.setEmail("teacher" + i + "@example.com");
            teacher.setResume("Resume " + i);
            mongoTemplate.save(teacher);
        }

        //  Entity data
        for (int i = 0; i < 50; i++) {
            Entity entity = new Entity();
            entity.setIsActive(i % 2 == 0); // Alternating isActive values
            mongoTemplate.save(entity);
        }

        //  Audio data
        for (int i = 0; i < 50; i++) {
            Audio audio = new Audio();
            audio.setIdStudent("Student " + i);
            audio.setIdEntity("Entity " + i);
            audio.setChapter("Chapter " + i);
            audio.setVerse("Verse " + i);
            mongoTemplate.save(audio);
        }
    }
}
