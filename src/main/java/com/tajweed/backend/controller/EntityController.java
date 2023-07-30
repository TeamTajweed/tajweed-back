package com.tajweed.backend.controller;

import com.tajweed.backend.dao.EntityRepository;
import com.tajweed.backend.model.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestApi
public class EntityController {

    public static Logger logger = LoggerFactory.getLogger(EntityController.class);

    @Autowired
    private EntityRepository repository;

    @RequestMapping("/entities")
    public Iterable<Entity> getEntities() {
        logger.info("Get entities");
        return repository.findAll();
    }
}

