package com.tajweed.backend.controller;

import com.tajweed.backend.dao.StudentRepository;
import com.tajweed.backend.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@RestApi
public class StudentController {

    public static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentRepository repository;

    @GetMapping("/students")
    @CrossOrigin
    public Iterable<Student> getStudents() {
        logger.info("Get students");
        return repository.findAll();

    }
}

