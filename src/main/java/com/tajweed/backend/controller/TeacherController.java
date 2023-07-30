package com.tajweed.backend.controller;

import com.tajweed.backend.dao.TeacherRepository;
import com.tajweed.backend.model.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    public static Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    private TeacherRepository repository;

    @RequestMapping("/teachers")
    public Iterable<Teacher> getTeachers() {
        logger.info("Get teacher");
        return repository.findAll();
    }
}

