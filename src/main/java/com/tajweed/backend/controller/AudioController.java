package com.tajweed.backend.controller;

import com.tajweed.backend.dao.AudioRepository;
import com.tajweed.backend.model.Audio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestApi
public class AudioController {

    public static Logger logger = LoggerFactory.getLogger(AudioController.class);

    @Autowired
    private AudioRepository repository;

    @RequestMapping("/audios")
    @CrossOrigin
    public Iterable<Audio> getAudios() {
        logger.info("Get audios");
        return repository.findAll();
    }
}

