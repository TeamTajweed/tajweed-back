package com.tajweed.backend.component;

import com.github.javafaker.Faker;
import com.tajweed.backend.model.*;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("populate")
public class TestData {

    private final MongoTemplate mongoTemplate;

    public TestData(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostConstruct
    public void seedData() {
        Faker faker = new Faker();

        //  Student data
        for (int i = 0; i < 50; i++) {

            User user = new User();
            user.setName(faker.name().fullName());
            user.setPassword("password" + i);
            user.setEmail("student" + i + "@example.com");

            mongoTemplate.save(user);

            Student student = new Student();
            student.setUser(user);
            student.setProgress("Progress " + i);

            mongoTemplate.save(student);

            Audio audio = new Audio();
            audio.setStudent(student);
            audio.setIdEntity("Entity " + i);
            audio.setChapter("Sourate " + i);
            audio.setVerse("Verset " + i);
            mongoTemplate.save(audio);
        }

        //  Teacher data
        for (int i = 0; i < 50; i++) {
            User user = new User();
            user.setName(faker.name().fullName());
            user.setPassword("password" + i);
            user.setEmail("teacher" + i + "@example.com");

            mongoTemplate.save(user);

            Teacher teacher = new Teacher();
            teacher.setUser(user);
            teacher.setResume("Resume " + i);
            mongoTemplate.save(teacher);
        }

        //  Entity data
        for (int i = 0; i < 50; i++) {
            Entity entity = new Entity();
            entity.setIsActive(i % 2 == 0); // Alternating isActive values
            mongoTemplate.save(entity);
        }

    }
}
